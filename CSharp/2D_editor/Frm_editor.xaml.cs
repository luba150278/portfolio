using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;
using System.Windows.Shapes;
using static System.Convert;
using System.Windows.Input;
using System.Collections.Generic;
using System;
using System.Linq;

namespace GoToKnit_
{
	/// <summary>
	/// Логика взаимодействия для Frm_editor.xaml
	/// </summary>
	public partial class Frm_editor : Window
	{
        protected Boolean isDragging;
        private Point mousePosition;
        private Double prevX, prevY;
        int index_el=0;
        int index_el_left=0;
        int index_el_right=0;
        Line line1;
        Line line2;
        //protected bool isDragging;
        //Point clickPosition;

        //Point currentPoint = new Point();
        double k_prop = 1; //коэффициент для шага сетки
        double k_prop_x, k_prop_y;
        double main_w, main_h;        
        private Polyline polyline;
        private Polyline segment = new Polyline { StrokeThickness = 2 };
        //private Polyline segment_left = new Polyline { Stroke = Brushes.Green, StrokeThickness = 2 };
        //private Polyline segment_right = new Polyline { Stroke = Brushes.Green, StrokeThickness = 2 };
        int count_pnts = 1;
        List<Points_new> pnts = new List<Points_new>();
        List<Points_new> list_main = new List<Points_new>();
        List<Koord> list_det = new List<Koord>();
        private List<Ellipse> ellipses;
        List<Point> tocki;
        bool prov_poligon = false;
        double BG_korr;
        Polygon main_polygon;
        public Frm_editor()
		{
			InitializeComponent();
            UpdateBackPattern(null, null);
		}

        class Points_new
        {
            public Points_new(int n, double X, double Y)
            {
                this.n = n;
                this.X = X;//0
                this.Y = Y;//1           
            }

            public int n { get; set; }
            public double X { get; set; }
            public double Y { get; set; }

        }

        class Koord
        {
            public Koord(int n, double X, double Y, string det)
            {
                this.n = n;
                this.X = X;//0
                this.Y = Y;//1
                this.det = det;//1
            }

            public int n { get; set; }
            public double X { get; set; }
            public double Y { get; set; }
            public string det { get; set; }

        }

        void UpdateBackPattern(object sender, SizeChangedEventArgs e)
        {
            double w = Background.Width;
            double h = Background.Height;
            Ris_canvas();
            Prov_arr();
        }

        void Ris_canvas()//разлиновка
        {
            double w = Background.Width;
            double h = Background.Height;
            double ris = ToInt32(10 * k_prop);//шаг сетки
            double shag = ToInt32(100 * k_prop);
            double prov = h / 100;
            double prov1 = h - ToInt32(h / 100) * 100;
            
            
            if (prov1 != 0)
            {
                h = ToInt32(prov) * shag;
                k_prop_x = prov1;
                if (k_prop == 1) BG_korr = h;
            }           

            prov = w / shag;
            prov1 = w - ToInt32(w / shag) * shag;

            if (prov1 != 0)
            {
                w = ToInt32(prov) * shag;
                k_prop_y = prov1;
            }

          
            int z = 1;
            Background.Children.Clear();
           
            for (double x = 0; x < w; x += ris)
            {
                if (x % shag == 0)
                {
                    z = 2;
                    Tb_forline((x / ris).ToString(), true, x, -ris, Colors.Purple);
                    Tb_forline((x / ris).ToString(), true, x, h, Colors.Purple);
                }
                AddLineToBackground(x, 0, x, h, z, Brushes.LightGray);
                z = 1;
            }
            for (double y = ToInt32(h); y > 0; y -= ris)
            {
                if (y % shag == 0)
                {
                    z = 2;
                    Tb_forline(((ToInt32(h) - y) / ris).ToString(), false, -20, y, Colors.Purple);
                    Tb_forline(((ToInt32(h) - y) / ris).ToString(), false, w, y, Colors.Purple);

                }
                AddLineToBackground(0, y, w, y, z, Brushes.LightGray);
                z = 1;
            }

            //Background.Children.Add(Background);
        }

        void AddLineToBackground(double x1, double y1, double x2, double y2, int z, Brush clr)
        {
            var line = new Line()
            {
                X1 = x1,
                Y1 = y1,
                X2 = x2,
                Y2 = y2,
                Stroke = clr,
                StrokeThickness = z,
                SnapsToDevicePixels = true
            };
            line.SetValue(RenderOptions.EdgeModeProperty, EdgeMode.Aliased);
            Background.Children.Add(line);
            
        }

        private void Tb_forline(string mstr, bool rot, double x, double y, Color clr)// текстовые надписи
        {
            TextBlock tb = new TextBlock();
            tb.Text = mstr;
            tb.Foreground = new SolidColorBrush(clr);
            if (rot == true) tb.LayoutTransform = new RotateTransform(-90);
            Canvas.SetLeft(tb, x);
            Canvas.SetTop(tb, y);
            Background.Children.Add(tb);
        }

        private void Btn_dec_Click(object sender, RoutedEventArgs e)
        {
            k_prop = Math.Round(k_prop*1.1,1);
            double k_bg = Math.Round(1 + k_prop / 20, 1);
            MainCanvas.Width= MainCanvas.ActualWidth * k_bg;
            MainCanvas.Height = MainCanvas.ActualHeight * k_bg;
           
        }
        private void Prov_arr()
        {
            //if (pnts.Count > 0)
            //{
            //    Prov_points();
            //    Draw_poligon();
            //}
        }
        private void Btn_inc_Click(object sender, RoutedEventArgs e)
        {
           
        }

      
        private void MainCanvas_MouseDown(object sender, MouseButtonEventArgs e)
        {
          
        }

        private void MainCanvas_MouseMove(object sender, MouseEventArgs e)//рисуем линии мышкой
        {          
            if (polyline != null)
            {
                // update current polyline segment
                var canvas = (Canvas)sender;
                segment.Points[1] = e.GetPosition(canvas);

                var distance = (segment.Points[0] - segment.Points[1]).Length;
                segment.Stroke = distance >= 5 ? Brushes.Green : Brushes.Red;//было 20
            }
        }

        private void MainCanvas_MouseLeftButtonDown(object sender, MouseButtonEventArgs e)
        {           
           
            if (polyline == null && prov_poligon == false)
            {
                var canvas = (Canvas)sender;
                var point = e.GetPosition(canvas);
                pnts.Add(new Points_new(count_pnts, point.X, point.Y));
                // create new polyline
                polyline = new Polyline { Stroke = Brushes.Black, StrokeThickness = 2 };
                polyline.Points.Add(point);
                //Make_ellipse(point.X, point.Y);
                Background.Children.Add(polyline);

                // initialize current polyline segment
                segment.Stroke = Brushes.Red;
                segment.Points.Add(point);
                segment.Points.Add(point);
                Background.Children.Add(segment);
                count_pnts++;
                
            }
        }

        private void MainCanvas_MouseLeftButtonUp(object sender, MouseButtonEventArgs e)
        {
            if (polyline != null)
            {
                var canvas = (Canvas)sender;
                segment.Points[1] = e.GetPosition(canvas);

                var distance = (segment.Points[0] - segment.Points[1]).Length;
                
                if (distance >= 5)//20было
                {
                    var point = e.GetPosition(canvas);
                    polyline.Points.Add(segment.Points[1]);
                    segment.Points[0] = segment.Points[1];
                    pnts.Add(new Points_new(count_pnts, point.X, point.Y));
                    //Make_ellipse(point.X, point.Y);
                    count_pnts++;
                }
                else
                {
                    if (polyline.Points.Count < 2)
                    {
                        Background.Children.Remove(polyline);
                    }

                    polyline = null;
                    segment.Points.Clear();
                    Background.Children.Remove(segment);
                    pnts.Clear();
                }
            }
           
        }

        private void Btn_polyline_Click(object sender, RoutedEventArgs e)
        {
            string str = "";
            try
            {
                for (int i = 0; i < pnts.Count; i++) str = str + "n:" + pnts[i].n + "X:" + pnts[i].X + "Y:" + pnts[i].Y + '\n';
                str = str + "------------------\n";
                MessageBox.Show(pnts.Count + ":"+list_main.Count);
                for (int i = 0; i < list_main.Count; i++) str = str + "n:" + list_main[i].n + "X:" + list_main[i].X + "Y:" + list_main[i].Y + '\n';
                str = str + "bg_h" + BG_korr;
                MessageBox.Show(str);

                //MessageBox.Show(""+Background.Children.OfType<Ellipse>().Count());
            }

            catch { }

            
        }

        private void Btn_del_Click(object sender, RoutedEventArgs e)
        {
            
            Del_all(true);
            Ris_canvas();
        }

        private void Del_all(bool all)
        {
            if (all == true)
            {
                pnts = new List<Points_new>();
                list_main = new List<Points_new>();
                count_pnts = 1;
                prov_poligon = false;
                ellipses = new List<Ellipse>();
            }
            Background.Children.Clear();
            //UpdateBackPattern(null, null);
            
        }
        private void Window_KeyDown(object sender, KeyEventArgs e)
        {
            if (e.Key == Key.LeftShift)
            {                
                int cnt = pnts.Count - 1;
                
                if (cnt > 1)
                {
                    //AddLineToBackground(pnts[0].X, pnts[0].Y, pnts[cnt].X, pnts[cnt].Y, 2, Brushes.Black);
                    Prov_points();
                    Draw_poligon();
                    polyline = null;
                    segment.Points.Clear();
                    Background.Children.Remove(segment);
                    prov_poligon = true;
                }
            }
            if(e.Key == Key.LeftCtrl)
            {
                Draw_sim();
            }
        }

        private void Btn_sim_Click(object sender, RoutedEventArgs e)
        {
            Draw_sim();
        }

        private void Draw_sim()
        {
            if (prov_poligon == true)
            {
                MessageBox.Show("Нельзя построить симметричную часть для замкнутого контура");
                return;
            }

            Prov_points();//убираем двойные точки

            int cnt = pnts.Count - 1; //точка симметрии
            count_pnts = pnts.Count + 1;
            int comm_pnts = pnts.Count * 2 - 1;
            int del = comm_pnts - pnts.Count;
            for (int i = 0; i < del; i++)
            {
                double Y = pnts[cnt - (i + 1)].Y;
                double X = pnts[cnt].X + (pnts[cnt].X - pnts[cnt - (i + 1)].X);
                pnts.Add(new Points_new(count_pnts, X, Y));
                count_pnts++;
            }
            Del_all(false);
            Draw_poligon();
            prov_poligon = true;
            
        }

        private void Prov_points()
        {
            int n = 1;
            double delt_x;
            double delt_y;
            List<Points_new> new_list = new List<Points_new>();
            for(int i=1; i<pnts.Count;i++)
            {
                delt_x = Math.Abs(Math.Abs(pnts[i].X)- Math.Abs(pnts[i-1].X));
                delt_y = Math.Abs(Math.Abs(pnts[i].Y) - Math.Abs(pnts[i-1].Y));
                
                if (delt_x>5 || delt_y>5)
                {
                    new_list.Add(new Points_new(n, pnts[i - 1].X, pnts[i - 1].Y));
                    n++;
                }
            }

            delt_x = Math.Abs(Math.Abs(pnts[pnts.Count - 1].X) - Math.Abs(pnts[0].X));
            delt_y = Math.Abs(Math.Abs(pnts[pnts.Count - 1].Y) - Math.Abs(pnts[0].Y));
            if (delt_x > 5 || delt_y > 5)
            {
                new_list.Add(new Points_new(n, pnts[pnts.Count - 1].X, pnts[pnts.Count - 1].Y));
            }
            pnts = new_list;
            
        }

        private void Btn_point_Click(object sender, RoutedEventArgs e)
        {

            if (prov_poligon == false) { Create_my(); }
        }

        void Make_ellipse(double x2, double y2)
        {
            Ellipse elipse=new Ellipse();
            elipse.Width = 6;
            elipse.Height = 6;
            elipse.StrokeThickness = 1;
            elipse.Stroke = Brushes.Black;
            elipse.Fill = Brushes.Black;
            elipse.Margin = new Thickness(x2 - 3, y2 - 3, 0, 0);
            Background.Children.Add(elipse);

        }

        private void Create_my()
        {
            try
            {
                Point point = new Point();
                point.X = ToDouble(TB_X.Text) * 10;
                point.Y = BG_korr - ToDouble(TB_Y.Text) * 10;
                pnts.Add(new Points_new(count_pnts, point.X, point.Y));

                if (count_pnts == 1)
                {
                    Make_ellipse(point.X, point.Y);
                    polyline = new Polyline { Stroke = Brushes.Black, StrokeThickness = 2 };
                    polyline.Points.Add(point);
                    Background.Children.Add(polyline);
                }
                if (count_pnts > 1)
                {
                    double x1 = pnts[count_pnts - 2].X;
                    double y1 = pnts[count_pnts - 2].Y;
                    double x2 = pnts[count_pnts - 1].X;
                    double y2 = pnts[count_pnts - 1].Y;
                    polyline.Points.Add(point);
                    Make_ellipse(x2, y2);

                    //AddLineToBackground(x1, y1, x2, y2,2, Brushes.Black);
                }
                count_pnts++;

                
            }

            catch{  }
        }



        private void TB_Name_KeyDown(object sender, KeyEventArgs e)
        {
            if (e.Key == Key.Enter)
            {
                if (LB_names.Items.Count > 0)
                {
                    for (int i = 0; i < LB_names.Items.Count; i++)
                    {
                        if (LB_names.Items[i].ToString().ToLower() == TB_Name.Text.ToLower())
                        {
                            MessageBox.Show("Деталь с таким наименованием уже есть");
                            return;
                        }
                    }
                }
                LB_names.Items.Add(TB_Name.Text);
                for (int i = 0; i < LB_names.Items.Count; i++)
                {
                   if( LB_names.Items[i].ToString().ToLower() == TB_Name.Text.ToLower())
                   {
                        LB_names.SelectedIndex = i;
                        return;
                   }
                }

            }
        }

        private void Btn_save_det_Click(object sender, RoutedEventArgs e)
        {
            bool prov_exist_koord = false;
            if (LB_names.SelectedIndex == -1)
            {
                MessageBox.Show("Выберите деталь из спискаили добавьте деталь в список");
                return;
            }
            else
            {
                string det = LB_names.SelectedItem.ToString();
                if(list_det.Count>0)
                {
                    List<Koord> prov = list_det.FindAll(item => item.det.ToLower() == det.ToLower());
                    if (prov.Count > 0)
                    {
                        MessageBoxResult qu = MessageBox.Show("Для данной детали координаты уже введены. Обновить данные?", "Сохранить координаты детали", MessageBoxButton.YesNo, MessageBoxImage.Question);
                        switch (qu)
                        {
                            case MessageBoxResult.Yes:
                                prov_exist_koord = true;
                                break;
                            case MessageBoxResult.No:
                                return;
                              
                        }
                    }
                }

                Add_koord_det(det, prov_exist_koord);
            }
        }

        private void Add_koord_det(string det, bool prov)//prov ==true деталь уже есть. Обновляем данные
        {
            if(prov==true)//удаляем предыдущие координаты детали
            {
                list_det.RemoveAll(x => x.det == det);
            }
            for(int i=0; i<list_main.Count;i++)
            {
                list_det.Add(new Koord(list_main[i].n, list_main[i].X, list_main[i].Y, det)) ;
            }
            MessageBox.Show("Деталь добавлена");
        }


        private void Draw_poligon()
        {
            int num_min=0;
            int perv_chas;
            int k = 1;
           
            if (prov_poligon == false)
            {
                list_main = new List<Points_new>();
                
                List<Points_new> list_pnts = new List<Points_new>();
                for (int i = 0; i < pnts.Count; i++)
                {
                    list_pnts.Add(new Points_new(pnts[i].n, pnts[i].X / 10, (BG_korr - pnts[i].Y) / 10));
                }
               
                double y= list_pnts.AsQueryable().Min(x => x.Y);
                List<Points_new> list_prov=list_pnts.FindAll(item => item.Y == y);
                
                if (list_prov.Count == 1)
                {
                    num_min = list_prov[0].n;
                }
                else
                {
                    double x = list_prov.AsQueryable().Min(item => item.X);
                    list_prov = list_prov.FindAll(item => item.X == x);
                    num_min = list_prov[0].n;
                }
                
                if(num_min==1)//первая точка - точка минимума
                {
                    if(list_pnts[1].X<list_pnts[list_pnts.Count-1].X && Math.Abs(list_pnts[list_pnts.Count - 1].X- list_pnts[1].X) >0.5)
                    {
                        perv_chas = list_pnts[1].n;
                    }
                    else if(list_pnts[1].X > list_pnts[list_pnts.Count - 1].X && Math.Abs(list_pnts[1].X- list_pnts[list_pnts.Count - 1].X) > 0.5) { perv_chas = list_pnts[list_pnts.Count - 1].n; }
                    else
                    {//равная координата х

                        if (list_pnts[1].Y> list_pnts[list_pnts.Count - 1].Y) { perv_chas = list_pnts[1].n; }
                        else { perv_chas = list_pnts[list_pnts.Count - 1].n; }
                    }
                }
                else
                {
                    if(num_min == list_pnts[list_pnts.Count-1].n)//последняя точка
                    {
                        if (list_pnts[0].X < list_pnts[list_pnts.Count - 2].X)
                        {
                            perv_chas = list_pnts[0].n;
                        }
                        else { perv_chas = list_pnts[list_pnts.Count - 2].n; }
                    }
                    else
                    {
                        if (list_pnts[num_min-2].X < list_pnts[num_min].X && (Math.Abs(list_pnts[num_min].X- list_pnts[num_min - 2].X) > 0.5))
                        {
                            perv_chas = list_pnts[num_min - 2].n;
                        }
                        else if(list_pnts[num_min - 2].X > list_pnts[num_min].X && (Math.Abs(list_pnts[num_min - 2].X- list_pnts[num_min].X) >0.5)) { perv_chas = list_pnts[num_min].n; }
                        else
                        {//равная координата х

                            if (list_pnts[num_min - 2].Y > list_pnts[num_min].Y) { perv_chas = list_pnts[num_min - 2].n; }
                            else { perv_chas = list_pnts[num_min].n; }
                        }
                    }

                }

                list_prov = list_pnts.FindAll(item => item.n == num_min);
                list_main.Add(new Points_new(k, list_prov[0].X, list_prov[0].Y));
                k++;
                //MessageBox.Show("num" + num_min + "ch" + perv_chas);
                if(num_min<perv_chas)
                {
                    if (perv_chas != list_pnts.Count)
                    {
                        for (int i = perv_chas - 1; i < list_pnts.Count; i++)
                        {
                            list_main.Add(new Points_new(k, list_pnts[i].X, list_pnts[i].Y));
                            k++;
                        }

                        if (num_min > 1)
                        {
                            for (int i = 0; i <= num_min - 2; i++)
                            {
                                list_main.Add(new Points_new(k, list_pnts[i].X, list_pnts[i].Y));
                                k++;
                            }
                        }
                    }
                    else
                    {                       
                        for (int i = perv_chas - 1; i >= 0; i--)
                        {
                            if (i + 1 != num_min)
                            {
                                list_main.Add(new Points_new(k, list_pnts[i].X, list_pnts[i].Y));
                                k++;
                            }
                        }
                    }
                }
                else
                {
                    if (num_min == list_pnts.Count)
                    {
                        if (perv_chas != 1)
                        {
                            for (int i = perv_chas - 1; i >= 0; i--)
                            {
                                list_main.Add(new Points_new(k, list_pnts[i].X, list_pnts[i].Y));
                                k++;
                            }
                        }
                        else
                        {
                            for (int i =0; i <= num_min-2; i++)
                            {
                                list_main.Add(new Points_new(k, list_pnts[i].X, list_pnts[i].Y));
                                k++;
                            }
                        }
                    }
                    else
                    {
                        for (int i = perv_chas - 1; i==0; i--)
                        {
                            list_main.Add(new Points_new(k, list_pnts[i].X, list_pnts[i].Y));
                            k++;
                        }

                        for(int i= list_pnts.Count - 1;i>=num_min;i--)
                        {
                            list_main.Add(new Points_new(k, list_pnts[i].X, list_pnts[i].Y));
                            k++;
                        }
                    }
                }
            }

            main_polygon = new Polygon();
            main_polygon.Stroke = Brushes.Black;
            main_polygon.StrokeThickness = 2;

           
            Point[] pts = new Point[pnts.Count];
            PointCollection myPointCollection = new PointCollection();

            for (int i = 0; i < pnts.Count; i++)
            {
                pts[i] = new Point(pnts[i].X, pnts[i].Y);
                myPointCollection.Add(pts[i]);
            }

            main_polygon.Points = myPointCollection;


            Background.Children.Add(main_polygon);
            Add_polygon_events();
            polyline = null;
            //main_polygon = myPolygon;
            //main_polygon.Stroke=Brushes.Black;
            //main_polygon.StrokeThickness = 2;

            var fld = Background.Children.OfType<Polyline>().ToList();
            foreach (Polyline fld_d in fld) Background.Children.Remove(fld_d);

            var el = Background.Children.OfType<Ellipse>().ToList();
            foreach (Ellipse fld_d in el) Background.Children.Remove(fld_d);

            for (int i = 0; i < pnts.Count; i++)
            {
                Make_ellipse(pts[i].X, pts[i].Y);
            }

            Ellip_events();           
        }

        void Add_polygon_events()
        {
            main_polygon.MouseLeftButtonDown += new MouseButtonEventHandler(Control_MouseLeftButtonDown);
            main_polygon.MouseLeftButtonUp += new MouseButtonEventHandler(Control_MouseLeftButtonUp);
            main_polygon.MouseMove += new MouseEventHandler(Control_MouseMove);
        }

        private void Ellip_events()
        {
            isDragging = false;
            int i = 0;
            var el = Background.Children.OfType<Ellipse>().ToList();
            ellipses = new List<Ellipse>();
            foreach (Ellipse el_ch in el)
            {
                ellipses.Add(el_ch);
                el_ch.MouseLeftButtonDown += new MouseButtonEventHandler(Elipce_MouseLeftButtonDown);
                el_ch.MouseMove += new MouseEventHandler(Elipce_MouseMove);
                el_ch.MouseLeftButtonUp += new MouseButtonEventHandler(Ellipce_MouseLeftButtonUp);
                el_ch.Name = "e" + i;
                i++;
            }
        }

        private void Window_Loaded(object sender, RoutedEventArgs e)
        {
            main_w = MainCanvas.ActualWidth;
            main_h = MainCanvas.ActualHeight;
           
        }

        private void Elipce_MouseLeftButtonDown(object sender, MouseButtonEventArgs e)
        {

            prevX = 0;
            prevY = 0;

            var draggableControl = (sender as Ellipse);

            if (draggableControl.Fill == Brushes.Black)
            {
                draggableControl.Fill = Brushes.Red;
                draggableControl.Stroke = Brushes.Red;
                isDragging = true;
                var canvas = MainCanvas;
                mousePosition = e.GetPosition(canvas);
                draggableControl.CaptureMouse();
                index_el = ToInt32((sender as Ellipse).Name.Substring(1));
                if (index_el != pnts.Count - 1 && index_el != 0)
                {
                    index_el_left = index_el - 1;
                    index_el_right = index_el + 1;
                }
                else
                {
                    if (index_el == pnts.Count - 1)
                    {
                        index_el_left = index_el - 1;
                        index_el_right = 0;
                    }
                    if (index_el == 0)
                    {
                        index_el_left = pnts.Count - 1;
                        index_el_right = index_el + 1;
                    }
                }

                //var pg = Background.Children.OfType<Polygon>().ToList();
                //Polygon pg_ch = pg[0];
                Polygon pg_ch = main_polygon;

                tocki = new List<Point>();          
                tocki.Add(pg_ch.Points[index_el_left]);
                tocki.Add(pg_ch.Points[index_el_right]);

            }
            else
            {
                draggableControl.Fill = Brushes.Black;
                draggableControl.Stroke = Brushes.Black;
                isDragging = false;
            }
        }

        private void Elipce_MouseMove(object sender, MouseEventArgs e)
        {
            var draggableControl = (sender as Ellipse);


            if (isDragging == true)
            {
                var canvas = MainCanvas;
                var currentPosition = e.GetPosition(canvas);
                var transform = (draggableControl.RenderTransform as TranslateTransform);
                if (transform == null)
                {
                    transform = new TranslateTransform();
                    draggableControl.RenderTransform = transform;
                }

               
                transform.X = (currentPosition.X - mousePosition.X);
                transform.Y = (currentPosition.Y - mousePosition.Y);

                //segment_left.Points.Add(new Point(currentPosition.X, currentPosition.Y));
                //segment_right.Points.Add(new Point(currentPosition.X, currentPosition.Y));
                var fld = MainCanvas.Children.OfType<Line>().ToList();
                foreach (Line kn in fld) MainCanvas.Children.Remove(kn);
                line1= Make_line(tocki[0].X, tocki[0].Y, currentPosition.X, currentPosition.Y);
                line2 = Make_line(tocki[1].X, tocki[1].Y, currentPosition.X, currentPosition.Y);
                
                MainCanvas.Children.Add(line1);
                MainCanvas.Children.Add(line2);


                if (prevX > 0)
                {
                    transform.X += prevX;
                    transform.Y += prevY;
                }
            }
        }

        private Line Make_line(double x1, double y1, double x2, double y2)
        {

            var line = new Line()
            {
                X1 = x1,
                Y1 = y1,
                X2 = x2,
                Y2 = y2,
                Stroke = Brushes.Green,
                StrokeThickness = 2,
                SnapsToDevicePixels = true,
                StrokeDashArray = new DoubleCollection() { 2 }
            };

            return line;
        }

        private void Ellipce_MouseLeftButtonUp(object sender, MouseButtonEventArgs e)
        {
            isDragging = false;
            var draggable = (sender as Ellipse);
            var transform = (draggable.RenderTransform as TranslateTransform);
            if (transform != null)
            {
                prevX = transform.X;
                prevY = transform.Y;
            }
            draggable.ReleaseMouseCapture();
            draggable.Stroke = Brushes.Black;
            draggable.Fill = Brushes.Black;
            prevX = 0;
            prevY = 0;
            var el = Background.Children.OfType<Ellipse>().ToList();
            foreach (Ellipse fld_d in el) Background.Children.Remove(fld_d);

            List<Polygon> pg = Background.Children.OfType<Polygon>().ToList();
            foreach(Polygon pg_ch in pg)
            {
                for(int i=0; i<pg_ch.Points.Count; i++)
                {
                    if (i == index_el) 
                    {                
                        main_polygon.Points[index_el] = new Point(line1.X2, line1.Y2);
                    }                   
                }
                //main_polygon = pg_ch;               
            }
            

            var fld = MainCanvas.Children.OfType<Line>().ToList();
            foreach (Line kn in fld) MainCanvas.Children.Remove(kn);
            pg[0] = main_polygon;
            foreach (Polygon fld_d in pg) Background.Children.Remove(fld_d);
            Background.Children.Add(main_polygon);

            for(int i=0; i< main_polygon.Points.Count; i++) Make_ellipse(main_polygon.Points[i].X, main_polygon.Points[i].Y);
            Ellip_events();
        }

        private void Control_MouseLeftButtonDown(object sender, MouseButtonEventArgs e)
        {
            isDragging = true;
            var draggableControl = (sender as Polygon);
            mousePosition = e.GetPosition(this.Parent as UIElement);
            draggableControl.CaptureMouse();
            draggableControl.Stroke = Brushes.Red;
        }

        private void Window_MouseRightButtonDown(object sender, MouseButtonEventArgs e)
        {
            //ContextMenu cm = this.FindResource("cmButton") as ContextMenu;
            //cm.PlacementTarget = sender as Window;
            //cm.IsOpen = true;

            var pg = Background.Children.OfType<Polygon>().ToList();
            
            string str = "";
            for(int i=0; i< pg[0].Points.Count; i++)
            {
                str = str + pg[0].Points[i].X + ":" + pg[0].Points[i].Y+"mx"+main_polygon.Points[i].X + "my" + main_polygon.Points[i].Y + "\n";
            }

            MessageBox.Show(str);

        }

        private void Control_MouseLeftButtonUp(object sender, MouseButtonEventArgs e)
        {
            
            isDragging = false;
            var draggable = (sender as Polygon);
            var transform = (draggable.RenderTransform as TranslateTransform);
            if (transform != null)
            {
                prevX = transform.X;
                prevY = transform.Y;
            }
            draggable.ReleaseMouseCapture();
            draggable.Stroke = Brushes.Black;
            Change_poligon();
            Trans_polygon(sender);         
           
        }

        void Change_poligon()
        {
            List<Polygon> pg = Background.Children.OfType<Polygon>().ToList();
            main_polygon = new Polygon { Stroke = Brushes.Black, StrokeThickness = 2 };
            Point pnt;
            for (int i = 0; i < pg[0].Points.Count; i++)
            {
                pnt = new Point();
                pnt.X = pg[0].Points[i].X + prevX;
                pnt.Y = pg[0].Points[i].Y + prevY;
                main_polygon.Points.Add(pnt);
            }

            foreach (Polygon list in pg) Background.Children.Remove(list);
            Background.Children.Add(main_polygon);
            Add_polygon_events();
        }
        void Trans_polygon(object sender)
        {
            Polygon pg= (sender as Polygon);

            for (int i = 0; i < pg.Points.Count; i++)
            {
               Make_ellipse(pg.Points[i].X+ prevX, pg.Points[i].Y+ prevY);              
            }

            Ellip_events();
        }
        private void Control_MouseMove(object sender, MouseEventArgs e)
        {
            var draggableControl = (sender as Polygon);
            if (isDragging && draggableControl != null)
            {
                var currentPosition = e.GetPosition(this.Parent as UIElement);
                var transform = (draggableControl.RenderTransform as TranslateTransform);
                if (transform == null)
                {
                    transform = new TranslateTransform();
                    draggableControl.RenderTransform = transform;
                }
                transform.X = (currentPosition.X - mousePosition.X);
                transform.Y = (currentPosition.Y - mousePosition.Y);
                if (prevX > 0)
                {
                    transform.X += prevX;
                    transform.Y += prevY;
                }

                LB_koord.Content = transform.X.ToString() + ";" + transform.Y.ToString();

                var el = Background.Children.OfType<Ellipse>().ToList();
                foreach (Ellipse fld_d in el) Background.Children.Remove(fld_d);
            }           
            //draggableControl.Stroke = Brushes.Black;           
        }
        
    
    }    
}
