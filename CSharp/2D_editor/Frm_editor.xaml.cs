using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;
using System.Windows.Shapes;
using static System.Convert;
using System.Windows.Input;
using System.Collections.Generic;
using System;
using System.Linq;
using System.Windows.Media.Imaging;

namespace GoToKnit_
{
	/// <summary>
	/// Логика взаимодействия для Frm_editor.xaml
	/// </summary>
	public partial class Frm_editor : Window
	{
        bool some_points = false;//выделение нескольких точек
        bool prov_ell_click=false;
        bool prov_polygon_click = false;
        protected Boolean isDragging;
        private Point mousePosition;
        private Double prevX, prevY;
        int index_el=0;
        int index_el_left=0;
        int index_el_right=0;
        Line line1;
        Line line2;        
        double k_prop = 1; //коэффициент для шага сетки
        double k_prop_x, k_prop_y;
        double main_w, main_h;        
        private Polyline polyline;
        private Polyline segment = new Polyline { StrokeThickness = 2 };       
        int count_pnts = 1;
        List<Points_new> pnts = new List<Points_new>();
        List<Points_new> list_main = new List<Points_new>();
        List<Koord> list_det = new List<Koord>();       
        List<Point> tocki;
        bool prov_poligon = false;
        double BG_korr;
        Polygon main_polygon;
        bool bg_clear = true;
        Rectangle myRect;
        int[] arr_index;

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
            //var bg = Background.Children.OfType<Line>().ToList();
            //foreach(Line ln in bg) Background.Children.Remove(ln);
           
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
            var bg = Background.Children.OfType<Line>().ToList();
            foreach (Line ln in bg) Panel.SetZIndex(ln, 0);

            Panel.SetZIndex(Background, 0);
            var pg = Background.Children.OfType<Polygon>().ToList();
            foreach (Polygon pg1 in pg) Panel.SetZIndex(pg1, 9999);
            var el = Background.Children.OfType<Ellipse>().ToList();
            foreach (Ellipse el1 in el) Panel.SetZIndex(el1, 9999);
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
            var canvas = (Canvas)sender;
            if (polyline != null)
            {
                // update current polyline segment
                
                segment.Points[1] = e.GetPosition(canvas);

                var distance = (segment.Points[0] - segment.Points[1]).Length;
                segment.Stroke = distance >= 5 ? Brushes.Green : Brushes.Red;//было 20
            }

            if(prov_poligon==true )
            {
                if (prov_ell_click == true) return;
                if (prov_polygon_click == true) return;
                int k = 0;
                if (myRect == null || e.LeftButton == MouseButtonState.Released) return;
                var pos = e.GetPosition(Background);
                var x = Math.Min(pos.X, mousePosition.X);
                var y = Math.Min(pos.Y, mousePosition.Y);
                var w = Math.Max(pos.X, mousePosition.X)-x;
                var h = Math.Max(pos.Y, mousePosition.Y)-y;
                myRect.Width = w;
                myRect.Height = h;
                Canvas.SetLeft(myRect, x);
                Canvas.SetTop(myRect, y);

                for(int i=0; i< main_polygon.Points.Count; i++)
                {
                    k = 0;
                    if(pos.X< mousePosition.X)
                    {
                        if (main_polygon.Points[i].X >= pos.X && main_polygon.Points[i].X <= mousePosition.X) k++;
                    }
                    else 
                    {
                        if (main_polygon.Points[i].X >= mousePosition.X && main_polygon.Points[i].X <= pos.X) k++;
                    }

                    if (pos.Y < mousePosition.Y)
                    {
                        if (main_polygon.Points[i].Y >= pos.Y && main_polygon.Points[i].Y <= mousePosition.Y) k++;
                    }
                    else
                    {
                        if (main_polygon.Points[i].Y >= mousePosition.Y && main_polygon.Points[i].Y <= pos.Y) k++;
                    }

                    if(k==2)
                    {
                        var el = Background.Children.OfType<Ellipse>().ToList();
                        for(int j=0; j<el.Count; j++)
                        {
                            if(i==j)
                            {                                
                                el[j].Stroke = Brushes.Red;
                                el[j].Fill = Brushes.Red;
                            }
                        }
                        some_points = true;
                    }
                }
               
            }
        }

        private void MainCanvas_MouseLeftButtonDown(object sender, MouseButtonEventArgs e)
        {
            var canvas = (Canvas)sender;
            var point = e.GetPosition(canvas);
            if (polyline == null && prov_poligon == false)
            {
               
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
            if(prov_poligon==true)
            {
                if (prov_ell_click == true) return;
                if (prov_polygon_click == true) return;
                //MessageBox.Show("yyyy");
                canvas.CaptureMouse();
                mousePosition = e.GetPosition(Background);
                myRect = new Rectangle
                {
                    Stroke = Brushes.Red,
                    StrokeThickness = 2,
                    SnapsToDevicePixels = true,
                    StrokeDashArray = new DoubleCollection() { 2 }

                };

                Canvas.SetLeft(myRect, mousePosition.X);
                Canvas.SetTop(myRect, mousePosition.Y);
                MainCanvas.Children.Add(myRect);
                
            }

        }

        private void MainCanvas_MouseLeftButtonUp(object sender, MouseButtonEventArgs e)
        {
            var canvas = (Canvas)sender;
            if (polyline != null)
            {                
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

            if (prov_poligon == true)
            {
                if (prov_ell_click == true) return;
                if (prov_polygon_click == true) return;
                MainCanvas.Children.Remove(myRect);
                canvas.ReleaseMouseCapture();
               // MessageBox.Show("" + mousePosition.X + ":" + mousePosition.Y+ ":" + e.GetPosition(Background).X+":"+ e.GetPosition(Background).Y);
            }
           
        }

        private void Btn_polyline_Click(object sender, RoutedEventArgs e)
        {
            if (main_polygon.Points.Count == 0) return;
                
            Pixel_to_koord();
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
                
                if (LB_names.SelectedIndex!=-1)
                {
                    int index = LB_names.SelectedIndex;
                    string det = LB_names.SelectedItem.ToString();
                    list_det.RemoveAll(x => x.det == det);
                   
                    LB_names.Items.Remove(LB_names.SelectedItem);
                }
                
            }

            list_main.Clear();
            main_polygon.Points.Clear();
            Background.Children.Clear();
            UpdateBackPattern(null, null);
            prevX = 0;
            prevY = 0;
            some_points = false;//выделение нескольких точек
            prov_ell_click = false;
            prov_polygon_click = false;
            prov_poligon = false;
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
                polyline = null;
                segment.Points.Clear();
                Background.Children.Remove(segment);
                prov_poligon = true;
            }
            if(e.Key==Key.Escape)
            {
                Esc_call();
                
            }
        }

        private void Btn_sim_Click(object sender, RoutedEventArgs e)
        {
            Draw_sim();
        }

        private void Draw_sim()
        {
            try
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
               
                
                Draw_poligon();
                prov_poligon = true;
                //Del_all(false);
            }
            catch
            {
                MessageBox.Show("Для построения симметричной фигуры нужно\nпостроить хотя бы 2 точки/1 отрезок");
            }
            
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
            if (some_points == false)
            {
                if (prov_poligon == false) { Create_my(); }
            }
            else
            {
                List<Ellipse> elps = Background.Children.OfType<Ellipse>().ToList();
                
                foreach(Ellipse el in elps)
                {
                    if(el.Stroke==Brushes.Red && (Math.Abs(ToDouble(TB_X.Text))>0 || Math.Abs(ToDouble(TB_Y.Text)) > 0))
                    {
                        int index = ToInt32(el.Name.Substring(1));
                        double X = main_polygon.Points[index].X + ToDouble(TB_X.Text) * 10;                        
                        double Y = main_polygon.Points[index].Y - ToDouble(TB_Y.Text) * 10;
                        Recalc_polygon(index, X, Y);
                    }
                }
                some_points = false;

            }
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
                        Save_det();
                        return;
                   }
                }

            }
        }

        void Save_det()
        {
            if (main_polygon.Points.Count == 0) return;
            Pixel_to_koord();
            bool prov_exist_koord = false;
            if (LB_names.Items.Count > 0)
            {
                if (LB_names.SelectedIndex == -1)
                {
                    MessageBox.Show("Выберите деталь из списка или добавьте деталь в список");
                    return;
                }
                else
                {
                    string det = LB_names.SelectedItem.ToString();
                    if (list_det.Count > 0)
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
            else
            {
                MessageBox.Show("Введите название первой детали");
            }
        }
        private void Btn_save_det_Click(object sender, RoutedEventArgs e)
        {
            Save_det();
        }

        private void Add_koord_det(string det, bool prov)//prov ==true деталь уже есть. Обновляем данные
        {
            if(prov==true)//удаляем предыдущие координаты детали
            {
                list_det.RemoveAll(x => x.det == det);
            }

            MessageBox.Show(""+ list_main.Count);
            for(int i=0; i<list_main.Count;i++)
            {
                list_det.Add(new Koord(list_main[i].n, list_main[i].X, list_main[i].Y, det)) ;
            }
            MessageBox.Show("Деталь добавлена");
        }


        private void Pixel_to_koord()
        {

            int num_min = 0;
            int perv_chas;
            int k = 1;
           
                list_main = new List<Points_new>();

                List<Points_new> list_pnts = new List<Points_new>();
                for (int i = 0; i < main_polygon.Points.Count; i++)
                {
                    list_pnts.Add(new Points_new(i+1, main_polygon.Points[i].X / 10, (BG_korr - main_polygon.Points[i].Y) / 10));
                }

                double y = list_pnts.AsQueryable().Min(x => x.Y);
                List<Points_new> list_prov = list_pnts.FindAll(item => item.Y == y);

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

                if (num_min == 1)//первая точка - точка минимума
                {
                    if (list_pnts[1].X < list_pnts[list_pnts.Count - 1].X && Math.Abs(list_pnts[list_pnts.Count - 1].X - list_pnts[1].X) > 0.5)
                    {
                        perv_chas = list_pnts[1].n;
                    }
                    else if (list_pnts[1].X > list_pnts[list_pnts.Count - 1].X && Math.Abs(list_pnts[1].X - list_pnts[list_pnts.Count - 1].X) > 0.5) { perv_chas = list_pnts[list_pnts.Count - 1].n; }
                    else
                    {//равная координата х

                        if (list_pnts[1].Y > list_pnts[list_pnts.Count - 1].Y) { perv_chas = list_pnts[1].n; }
                        else { perv_chas = list_pnts[list_pnts.Count - 1].n; }
                    }
                }
                else
                {
                    if (num_min == list_pnts[list_pnts.Count - 1].n)//последняя точка
                    {
                        if (list_pnts[0].X < list_pnts[list_pnts.Count - 2].X)
                        {
                            perv_chas = list_pnts[0].n;
                        }
                        else { perv_chas = list_pnts[list_pnts.Count - 2].n; }
                    }
                    else
                    {
                        if (list_pnts[num_min - 2].X < list_pnts[num_min].X && (Math.Abs(list_pnts[num_min].X - list_pnts[num_min - 2].X) > 0.5))
                        {
                            perv_chas = list_pnts[num_min - 2].n;
                        }
                        else if (list_pnts[num_min - 2].X > list_pnts[num_min].X && (Math.Abs(list_pnts[num_min - 2].X - list_pnts[num_min].X) > 0.5)) { perv_chas = list_pnts[num_min].n; }
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
                if (num_min < perv_chas)
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
                            for (int i = 0; i <= num_min - 2; i++)
                            {
                                list_main.Add(new Points_new(k, list_pnts[i].X, list_pnts[i].Y));
                                k++;
                            }
                        }
                    }
                    else
                    {
                        for (int i = perv_chas - 1; i == 0; i--)
                        {
                            list_main.Add(new Points_new(k, list_pnts[i].X, list_pnts[i].Y));
                            k++;
                        }

                        for (int i = list_pnts.Count - 1; i >= num_min; i--)
                        {
                            list_main.Add(new Points_new(k, list_pnts[i].X, list_pnts[i].Y));
                            k++;
                        }
                    }
                }
            
        }

        private void Draw_poligon()
        {
            if (prov_poligon == false)
            {
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
        }

        void Esc_call()
        {
            var el = Background.Children.OfType<Ellipse>().ToList();
            foreach (Ellipse fld_d in el) Background.Children.Remove(fld_d);
            for (int i = 0; i < main_polygon.Points.Count; i++)
            {
                Make_ellipse(main_polygon.Points[i].X, main_polygon.Points[i].Y);
            }

            Ellip_events();
            var tb = MainCanvas.Children.OfType<TextBlock>().ToList();
            foreach (TextBlock tb1 in tb) MainCanvas.Children.Remove(tb1);
            some_points = false;
            prov_ell_click = false;
            prov_polygon_click = false;

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
           
            foreach (Ellipse el_ch in el)
            {                
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
            //MessageBox.Show("" + pnts.Count);
            try
            {
                var draggableControl = (sender as Ellipse);
                if (some_points == true)
                {
                    if (draggableControl.Fill == Brushes.Black)
                    {
                        draggableControl.Fill = Brushes.Red;
                        draggableControl.Stroke = Brushes.Red;
                    }
                    else
                    {
                        draggableControl.Fill = Brushes.Black;
                        draggableControl.Stroke = Brushes.Black;
                    }
                }
                if (some_points == false)
                {
                    prevX = 0;
                    prevY = 0;
                    prov_ell_click = true;

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
                        //Polygon pg_ch = main_polygon;

                        tocki = new List<Point>();
                        tocki.Add(main_polygon.Points[index_el_left]);
                        tocki.Add(main_polygon.Points[index_el_right]);
                    }


                    else
                    {
                        draggableControl.Fill = Brushes.Black;
                        draggableControl.Stroke = Brushes.Black;
                        isDragging = false;
                    }
                }
           
            }
            catch 
            {
                //TextBlock tb= new TextBlock();
                //tb.Text = "Кликните клавишу Esc для нормализации редактора";
                //tb.Foreground = Brushes.Red;
                //MainCanvas.Children.Add(tb);
                Esc_call();
            }
          
        }

        private void Elipce_MouseMove(object sender, MouseEventArgs e)
        {
            try
            {
                var draggableControl = (sender as Ellipse);

                if(some_points==true)
                {

                }
                if (some_points == false)
                {
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

                        //if (Math.Abs(transform.X) <3 && Math.Abs(transform.Y)<3) return;
                        transform.X = (currentPosition.X - mousePosition.X);
                        transform.Y = (currentPosition.Y - mousePosition.Y);

                        //segment_left.Points.Add(new Point(currentPosition.X, currentPosition.Y));
                        //segment_right.Points.Add(new Point(currentPosition.X, currentPosition.Y));
                        var fld = MainCanvas.Children.OfType<Line>().ToList();
                        foreach (Line kn in fld) MainCanvas.Children.Remove(kn);
                        line1 = Make_line(tocki[0].X, tocki[0].Y, currentPosition.X, currentPosition.Y);
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
            }
            catch
            {

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
            
            try
            {
                var draggable = (sender as Ellipse);
                if (some_points == true)
                {
                    
                }
                if (some_points == false)
                {
                    isDragging = false;

                    var transform = (draggable.RenderTransform as TranslateTransform);
                    if (Math.Abs(transform.X) < 3 && Math.Abs(transform.Y) < 3) return;
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

                    Recalc_polygon(index_el, line1.X2, line1.Y2);                    
                    var fld = MainCanvas.Children.OfType<Line>().ToList();
                    foreach (Line kn in fld) MainCanvas.Children.Remove(kn);                   
                }

                prov_ell_click = false;
            }
            catch
            {
                prevX = 0;
                prevY = 0;
                //TextBlock tb = new TextBlock();
                //tb.Text = "Кликните клавишу Esc для нормализации редактора";
                //tb.Foreground = Brushes.Red;
                //MainCanvas.Children.Add(tb);
                Esc_call();
                prov_ell_click = false;
            }
        }

        void Recalc_polygon(int index_el, double X, double Y)
        {
            var el = Background.Children.OfType<Ellipse>().ToList();
            foreach (Ellipse fld_d in el) Background.Children.Remove(fld_d);
            for (int i = 0; i < main_polygon.Points.Count; i++)
            {
                if (i == index_el)
                {
                    main_polygon.Points[index_el] = new Point(X, Y);
                }
            }

            for (int i = 0; i < main_polygon.Points.Count; i++) Make_ellipse(main_polygon.Points[i].X, main_polygon.Points[i].Y);
            Ellip_events();
        }

        private void Control_MouseLeftButtonDown(object sender, MouseButtonEventArgs e)
        {
            isDragging = true;
            var draggableControl = (sender as Polygon);
            mousePosition = e.GetPosition(this.Parent as UIElement);
            draggableControl.CaptureMouse();
            draggableControl.Stroke = Brushes.Red;
            prov_polygon_click = true;
        }

        private void Window_MouseRightButtonDown(object sender, MouseButtonEventArgs e)
        {
            ContextMenu cm = this.FindResource("cmButton") as ContextMenu;
            cm.PlacementTarget = sender as Window;
            cm.IsOpen = true;
            //try
            //{
            //    var pg = Background.Children.OfType<Polygon>().ToList();

            //    string str = "";
            //    for (int i = 0; i < pg[0].Points.Count; i++)
            //    {
            //        str = str + pg[0].Points[i].X + ":" + pg[0].Points[i].Y + "mx" + main_polygon.Points[i].X + "my" + main_polygon.Points[i].Y + "\n";
            //    }

            //    MessageBox.Show(str);
            //}
            //catch
            //{
            //    MessageBox.Show("Нет полигона");
            //}

        }

        private void Control_MouseLeftButtonUp(object sender, MouseButtonEventArgs e)
        {
            
            isDragging = false;
            var draggable = (sender as Polygon);            
            var transform = (draggable.RenderTransform as TranslateTransform);
            //MessageBox.Show("" + transform.X);
            if (transform != null)
            {
                prevX = transform.X;
                prevY = transform.Y;
            }
            draggable.ReleaseMouseCapture();
            draggable.Stroke = Brushes.Black;
            Change_poligon();
            Trans_polygon(sender);
            prov_polygon_click = false;
        }

        private void Btn_show_det_Click(object sender, RoutedEventArgs e)
        {
            if (LB_names.Items.Count == 0) return;

            if (LB_names.SelectedIndex == -1)
            {
                MessageBox.Show("Выделите деталь в списке, для котрой хотите посмотреть координаты");
            }
            string det = LB_names.SelectedItem.ToString();
            List<Koord> prov = list_det.FindAll(item => item.det.ToLower() == det.ToLower());
            string str = det+"\n";
            
            for(int i=0; i< main_polygon.Points.Count; i++)
            {
                str = str + "X:" + Math.Round(prov[i].X,1) + "; Y:" + Math.Round(prov[i].Y,1)+"pixX:"+ Math.Round(main_polygon.Points[i].X,1) + "pixY:" + Math.Round(main_polygon.Points[i].Y,1) + "\n";
            }

            MessageBox.Show(str);
        }

        private void Btn_grid_Click(object sender, RoutedEventArgs e)
        {
            if (bg_clear == true)
            {
                var bg = Background.Children.OfType<Line>().ToList();
                foreach (Line ln in bg) Background.Children.Remove(ln);

                bg_clear = false;
            }
            else
            {
                UpdateBackPattern(null, null);
                bg_clear = true;
            }
        }

        private void Btn_grid_MouseEnter(object sender, MouseEventArgs e)
        {
            Cnange_img(Img_grid, "Resources/border1.png", true);
        }

        private void Btn_grid_MouseLeave(object sender, MouseEventArgs e)
        {
            Cnange_img(Img_grid, "Resources/border.png", false);
        }

        private void Btn_del_MouseEnter(object sender, MouseEventArgs e)
        {
            Cnange_img( Img_del, "Resources/delete1.png", true);
        }

        private void Btn_del_MouseLeave(object sender, MouseEventArgs e)
        {
            Cnange_img( Img_del, "Resources/delete.png", false);

        }

        private void Cnange_img(Image img, string rsc, bool curs)
        {
           
            Uri fileUri = new Uri(rsc, UriKind.Relative);
            img.Source = new BitmapImage(fileUri);
            if (curs == true)
            {
                this.Cursor = Cursors.Hand;
            }
            else
            {
                this.Cursor = Cursors.Arrow;
            }
        }

        private void Btn_save_det_MouseEnter(object sender, MouseEventArgs e)
        {
            Cnange_img(Img_save, "Resources/save1.png", true);
        }

        private void Btn_save_det_MouseLeave(object sender, MouseEventArgs e)
        {
            Cnange_img(Img_save, "Resources/save.png", false);
        }

        private void Btn_sim_MouseEnter(object sender, MouseEventArgs e)
        {
            Cnange_img(Img_sim, "Resources/sim1.png", true);
        }

        private void Btn_sim_MouseLeave(object sender, MouseEventArgs e)
        {
            Cnange_img(Img_sim, "Resources/sim.png", false);
        }

        private void Btn_point_MouseEnter(object sender, MouseEventArgs e)
        {
            Cnange_img(Img_point, "Resources/points1.png", true);
        }

        private void Btn_point_MouseLeave(object sender, MouseEventArgs e)
        {
            Cnange_img(Img_point, "Resources/points.png", false);
        }

        private void Btn_close_MouseEnter(object sender, MouseEventArgs e)
        {
            Cnange_img(Img_close, "Resources/point_close1.png", true);
        }

        private void Btn_close_MouseLeave(object sender, MouseEventArgs e)
        {
            Cnange_img(Img_close, "Resources/point_close.png", false);
        }

        private void Btn_close_Click(object sender, RoutedEventArgs e)
        {
            int cnt = pnts.Count - 1;

            if (cnt > 1)
            {
                
                Prov_points();
                Draw_poligon();
                polyline = null;
                segment.Points.Clear();
                Background.Children.Remove(segment);
                prov_poligon = true;
            }
            else
            {
                MessageBox.Show("Чтобы создать закрытый контур нужно\nпостроить хотя бы 3 точки/2 отрезка");
            }
        }

        private void Btn_some_Click(object sender, RoutedEventArgs e)
        {
            //if (main_polygon.Points.Count == 0) { MessageBox.Show("Нет точек для выделения"); return; }
            try
            {
                if (some_points == false)
                {
                    if (main_polygon.Points.Count == 0) { MessageBox.Show("Нет точек для выделения"); return; }
                    some_points = true;
                    
                    Cnange_img(Img_some, "Resources/select1.png", false);

                }
                else
                {
                    
                    some_points = false;
                    
                    Cnange_img(Img_some, "Resources/select.png", false);
                }
            }
            catch
            {
                MessageBox.Show("Нет точек для выделения");
                Cnange_img(Img_some, "Resources/select.png", false);
                
            }
        }

        private void Btn_some_MouseEnter(object sender, MouseEventArgs e)
        {
            Cnange_img(Img_some, "Resources/select1.png", true);
        }

        private void Btn_some_MouseLeave(object sender, MouseEventArgs e)
        {
            if (some_points == false)
            {
                Cnange_img(Img_some, "Resources/select.png", false);
            }
        }

        private void Btn_left_MouseEnter(object sender, MouseEventArgs e)
        {
            Cnange_img(Img_left, "Resources/move_left1.png", true);
        }

        private void Btn_left_MouseLeave(object sender, MouseEventArgs e)
        {
            Cnange_img(Img_left, "Resources/move_left.png", false);
        }

        private void Btn_left_Click(object sender, RoutedEventArgs e)
        {
            int k = Prov_selected_elps();
            if (k < 2) { MessageBox.Show("Для преобразования необходимо выделить не менее двух точек!"); return; }
            else if (main_polygon.Points.Count==k)
            {
                MessageBox.Show("Нельзя переместить все точки контура в одну линию"); return;
            }
            else
            {
                double min_x = main_polygon.Points[arr_index[0]].X;
                for(int i=0; i<arr_index.Length;i++)
                {
                    if (main_polygon.Points[arr_index[i]].X < min_x) { min_x = main_polygon.Points[arr_index[i]].X; }
                }

                for (int i = 0; i < arr_index.Length; i++)
                {
                    Point pnt = new Point();
                    pnt.X = min_x;
                    pnt.Y = main_polygon.Points[arr_index[i]].Y;
                    main_polygon.Points[arr_index[i]] = pnt;
                    Make_ellipse(pnt.X, pnt.Y);
                }

                Esc_call();
            }            
        }

        int Prov_selected_elps()
        {
            int k = 0;
            List<Ellipse> el = Background.Children.OfType<Ellipse>().ToList();
            for (int i=0; i< el.Count; i++)
            {               
                if (el[i].Stroke == Brushes.Red) { k++; }
            }
            if(k >= 2 && k < main_polygon.Points.Count)
            {
                arr_index = new int[k];
                k = 0;
                for (int i = 0; i < el.Count; i++)
                {
                    if (el[i].Stroke == Brushes.Red) { 
                        arr_index[k] = i;
                        k++; 
                        Background.Children.Remove(el[i]); 
                    }
                }

            }
            return k;
        }

        private void Btn_rignt_Click(object sender, RoutedEventArgs e)
        {
            int k = Prov_selected_elps();
            if (k < 2) { MessageBox.Show("Для преобразования необходимо выделить не менее двух точек!"); return; }
            else if (main_polygon.Points.Count == k)
            {
                MessageBox.Show("Нельзя переместить все точки контура в одну линию"); return;
            }
            else
            {
                double max_x = main_polygon.Points[arr_index[0]].X;
                for (int i = 0; i < arr_index.Length; i++)
                {
                    if (main_polygon.Points[arr_index[i]].X > max_x) { max_x = main_polygon.Points[arr_index[i]].X; }
                }

                for (int i = 0; i < arr_index.Length; i++)
                {
                    Point pnt = new Point();
                    pnt.X = max_x;
                    pnt.Y = main_polygon.Points[arr_index[i]].Y;
                    main_polygon.Points[arr_index[i]] = pnt;
                    Make_ellipse(pnt.X, pnt.Y);
                }

                Esc_call();
            }
        }

        private void Btn_rignt_MouseEnter(object sender, MouseEventArgs e)
        {
            Cnange_img(Img_right, "Resources/move_right1.png", true);
        }

        private void Btn_rignt_MouseLeave(object sender, MouseEventArgs e)
        {
            Cnange_img(Img_right, "Resources/move_right.png", false);
        }

        private void Btn_up_MouseEnter(object sender, MouseEventArgs e)
        {
            Cnange_img(Img_up, "Resources/move_up1.png", true);
        }

        private void Btn_up_MouseLeave(object sender, MouseEventArgs e)
        {
            Cnange_img(Img_up, "Resources/move_up.png", false);
        }

        private void Btn_up_Click(object sender, RoutedEventArgs e)
        {
            int k = Prov_selected_elps();
            if (k < 2) { MessageBox.Show("Для преобразования необходимо выделить не менее двух точек!"); return; }
            else if (main_polygon.Points.Count == k)
            {
                MessageBox.Show("Нельзя переместить все точки контура в одну линию"); return;
            }
            else
            {
                double min_y = main_polygon.Points[arr_index[0]].Y;
                for (int i = 0; i < arr_index.Length; i++)
                {
                    if (main_polygon.Points[arr_index[i]].Y < min_y) { min_y = main_polygon.Points[arr_index[i]].Y; }
                }

                for (int i = 0; i < arr_index.Length; i++)
                {
                    Point pnt = new Point();
                    pnt.X = main_polygon.Points[arr_index[i]].X;
                    pnt.Y = min_y;
                    main_polygon.Points[arr_index[i]] = pnt;
                    Make_ellipse(pnt.X, pnt.Y);
                }
                Esc_call();
            }
        }

        private void Btn_down_Click(object sender, RoutedEventArgs e)
        {
            int k = Prov_selected_elps();
            if (k < 2) { MessageBox.Show("Для преобразования необходимо выделить не менее двух точек!"); return; }
            else if (main_polygon.Points.Count == k)
            {
                MessageBox.Show("Нельзя переместить все точки контура в одну линию"); return;
            }
            else
            {
                double max_y = main_polygon.Points[arr_index[0]].Y;
                for (int i = 0; i < arr_index.Length; i++)
                {
                    if (main_polygon.Points[arr_index[i]].Y > max_y) { max_y = main_polygon.Points[arr_index[i]].Y; }
                }

                for (int i = 0; i < arr_index.Length; i++)
                {
                    Point pnt = new Point();
                    pnt.X = main_polygon.Points[arr_index[i]].X;
                    pnt.Y = max_y;
                    main_polygon.Points[arr_index[i]] = pnt;
                    Make_ellipse(pnt.X, pnt.Y);
                }
                Esc_call();
            }
        }

        private void Btn_down_MouseEnter(object sender, MouseEventArgs e)
        {
            Cnange_img(Img_down, "Resources/move_down1.png", true);
        }

        private void Btn_down_MouseLeave(object sender, MouseEventArgs e)
        {
            Cnange_img(Img_down, "Resources/move_down.png", false);
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
            prevX = 0;
            prevY = 0;
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
                //if (Math.Abs(transform.X) < 3 && Math.Abs(transform.Y) < 3) return;
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

//Рисование прямоугольника по клеткам канваса

//var myRect = new Rectangle();
//myRect.Fill = Brushes.OrangeRed;
//myRect.Stroke = Brushes.Red;
//myRect.StrokeThickness = 2;
//myRect.Width = 10; //RectWidth;
//myRect.Height = 10; //RectHeight;
//int PositionX = (int)(Math.Floor(e.GetPosition(MainCanvas).X / 10) * 10);
//// вычисляем позицию по оси X для добавления прямоугольника 
//int PositionY = (int)(Math.Floor(e.GetPosition(MainCanvas).Y / 10) * 10);
//// вычисляем позицию по оси Y для добавления прямоугольника
//Canvas.SetLeft(myRect, PositionX);
//Canvas.SetTop(myRect, PositionY);
//MainCanvas.Children.Add(myRect);
