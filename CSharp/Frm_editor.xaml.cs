using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;
using System.Windows.Shapes;
using static System.Convert;
using static System.Math;
using System.Windows.Input;
using System.Collections.Generic;
using System;

namespace GoToKnit_
{
	/// <summary>
	/// Логика взаимодействия для Frm_editor.xaml
	/// </summary>
	public partial class Frm_editor : Window
	{
        Point currentPoint = new Point();
        double k_prop = 1; //коэффициент для шага сетки
        double k_prop_x, k_prop_y;
        double main_w, main_h;
        private Polyline polyline;
        private Polyline segment = new Polyline { StrokeThickness = 2 };
        int count_pnts = 1;
        List<Points> pnts = new List<Points>();
        List<Points> list_main = new List<Points>();
        List<Koord> list_det = new List<Koord>();
        bool prov_poligon = false;
        double BG_korr;
        public Frm_editor()
		{
			InitializeComponent();
            UpdateBackPattern(null, null);
		}

        class Points
        {
            public Points(int n, double X, double Y)
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

        void Ris_canvas()
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
            if (pnts.Count > 0)
            {
                Prov_points();
                Draw_poligon();
            }
        }
        private void Btn_inc_Click(object sender, RoutedEventArgs e)
        {
           
        }

      
        private void MainCanvas_MouseDown(object sender, MouseButtonEventArgs e)
        {
            //if (e.ButtonState == MouseButtonState.Pressed)
            //{
            //    currentPoint = e.GetPosition(this);
            //}
            //-----------------------------------------
            //Point point = new Point(30, 30);
            //Ellipse elipse = new Ellipse();
            //elipse.Width = 10;
            //elipse.Height = 10;
            //elipse.StrokeThickness = 2;
            //elipse.Stroke = Brushes.Black;
            //elipse.Margin = new Thickness(point.X - 2, point.Y - 2, 0, 0);
            //Background.Children.Add(elipse);
        }

        private void MainCanvas_MouseMove(object sender, MouseEventArgs e)
        {
            //if (e.LeftButton == MouseButtonState.Pressed)
            //{
            //    Line line = new Line();

            //    line.Stroke = SystemColors.WindowFrameBrush;
            //    line.X1 = currentPoint.X;
            //    line.Y1 = currentPoint.Y;
            //    line.X2 = e.GetPosition(this).X;
            //    line.Y2 = e.GetPosition(this).Y;

            //    currentPoint = e.GetPosition(this);

            //    Background.Children.Add(line);

            //}

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
               pnts.Add(new Points(count_pnts,point.X,point.Y));
                // create new polyline
                polyline = new Polyline { Stroke = Brushes.Black, StrokeThickness = 2 };
                polyline.Points.Add(point);
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
                    pnts.Add(new Points(count_pnts, point.X, point.Y));
                    count_pnts++;
                }
                else
                {
                    if (polyline.Points.Count < 2)
                    {
                        canvas.Children.Remove(polyline);
                    }

                    polyline = null;
                    segment.Points.Clear();
                    Background.Children.Remove(segment);
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
            }

            catch { }

            
        }

        private void Btn_del_Click(object sender, RoutedEventArgs e)
        {
            Del_all(true);
           
        }

        private void Del_all(bool all)
        {
            if (all == true)
            {
                pnts = new List<Points>();
                list_main = new List<Points>();
                count_pnts = 1;
                prov_poligon = false;
            }
            Background.Children.Clear();
            UpdateBackPattern(null, null);
            
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
                pnts.Add(new Points(count_pnts, X, Y));
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
            List<Points> new_list = new List<Points>();
            for(int i=1; i<pnts.Count;i++)
            {
                delt_x = Math.Abs(Math.Abs(pnts[i].X)- Math.Abs(pnts[i-1].X));
                delt_y = Math.Abs(Math.Abs(pnts[i].Y) - Math.Abs(pnts[i-1].Y));
                
                if (delt_x>5 || delt_y>5)
                {
                    new_list.Add(new Points(n, pnts[i - 1].X, pnts[i - 1].Y));
                    n++;
                }
            }

            delt_x = Math.Abs(Math.Abs(pnts[pnts.Count - 1].X) - Math.Abs(pnts[0].X));
            delt_y = Math.Abs(Math.Abs(pnts[pnts.Count - 1].Y) - Math.Abs(pnts[0].Y));
            if (delt_x > 5 || delt_y > 5)
            {
                new_list.Add(new Points(n, pnts[pnts.Count - 1].X, pnts[pnts.Count - 1].Y));
            }
            pnts = new_list;
            
        }

        private void Btn_point_Click(object sender, RoutedEventArgs e)
        {

            Create_my();
        }

        private void Create_my()
        {

            Point point = new Point();
            point.X = ToDouble(TB_X.Text)*10;
            point.Y= BG_korr-ToDouble(TB_Y.Text) * 10;
            pnts.Add(new Points(count_pnts, point.X, point.Y));

            //polyline = new Polyline { Stroke = Brushes.Black, StrokeThickness = 2 };
            //polyline.Points.Add(point);
            //Background.Children.Add(polyline);
            if (count_pnts==1) {
                
                Ellipse elipse = new Ellipse();
                elipse.Width = 6;
                elipse.Height = 6;
                elipse.StrokeThickness = 1;
                elipse.Stroke = Brushes.Black;
                elipse.Fill = Brushes.Black;
                elipse.Margin = new Thickness(point.X-3 , point.Y-3 , 0, 0);
                Background.Children.Add(elipse);
            }
                if (count_pnts > 1) {
                double x1 = pnts[count_pnts - 2].X;
                double y1 = pnts[count_pnts - 2].Y;
                double x2 = pnts[count_pnts - 1].X;
                double y2 = pnts[count_pnts - 1].Y;
                AddLineToBackground(x1, y1, x2, y2,2, Brushes.Black);
            }
            count_pnts++;        
          
          
          
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
           
            if(prov_poligon == false)
            {
                list_main = new List<Points>();
                for(int i=0; i<pnts.Count;i++)
                {
                    list_main.Add(new Points(pnts[i].n, pnts[i].X / 10, (BG_korr - pnts[i].Y) / 10));
                }
            }

            Polygon myPolygon = new Polygon();
            myPolygon.Stroke = Brushes.Black;           
            myPolygon.StrokeThickness = 2;

           
            Point[] pts = new Point[pnts.Count];
            PointCollection myPointCollection = new PointCollection();

            for (int i = 0; i < pnts.Count; i++)
            {
                pts[i] = new Point(pnts[i].X, pnts[i].Y);
                myPointCollection.Add(pts[i]);
            }            

            myPolygon.Points = myPointCollection;
            Background.Children.Add(myPolygon);

        }

        private void Window_Loaded(object sender, RoutedEventArgs e)
        {
            main_w = MainCanvas.ActualWidth;
            main_h = MainCanvas.ActualHeight;
           
        }
    }    
}
