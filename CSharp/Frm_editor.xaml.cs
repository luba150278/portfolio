using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;
using System.Windows.Shapes;
using static System.Convert;
using System.Windows.Input;
using System.Collections.Generic;


namespace GoToKnit_
{
	/// <summary>
	/// Логика взаимодействия для Frm_editor.xaml
	/// </summary>
	public partial class Frm_editor : Window
	{
        Point currentPoint = new Point();
        private Polyline polyline;
        private Polyline segment = new Polyline { StrokeThickness = 2 };
        int n = 1;
        List<Points> pnts = new List<Points>();
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

        void UpdateBackPattern(object sender, SizeChangedEventArgs e)
        {
            double w = Background.ActualWidth;
            double h = Background.ActualHeight;
            Ris_canvas(w, h);
        }

        void Ris_canvas(double w, double h)
        {
            double prov = h / 100;
            double prov1 = h - ToInt32(h / 100) * 100;

            if (prov1 != 0)
            {
                h = ToInt32(prov) * 100;
            }


            prov = w / 100;
            prov1 = w - ToInt32(w / 100) * 100;

            if (prov1 != 0)
            {
                w = ToInt32(prov) * 100;
            }

            int z = 1;
            Background.Children.Clear();
            for (int x = 0; x < w; x += 10)
            {
                if (x % 100 == 0)
                {
                    z = 2;
                    Tb_forline((x / 10).ToString(), true, x, -20, Colors.Purple);
                    Tb_forline((x / 10).ToString(), true, x, h, Colors.Purple);
                }
                AddLineToBackground(x, 0, x, h, z);
                z = 1;
            }
            for (int y = ToInt32(h); y > 0; y -= 10)
            {
                if (y % 100 == 0)
                {
                    z = 2;
                    Tb_forline(((ToInt32(h) - y) / 10).ToString(), false, -20, y, Colors.Purple);
                    Tb_forline(((ToInt32(h) - y) / 10).ToString(), false, w, y, Colors.Purple);

                }
                AddLineToBackground(0, y, w, y, z);
                z = 1;
            }
        }
        void AddLineToBackground(double x1, double y1, double x2, double y2, int z)
        {
            var line = new Line()
            {
                X1 = x1,
                Y1 = y1,
                X2 = x2,
                Y2 = y2,
                Stroke = Brushes.LightGray,
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
           
            MainCanvas.Height = MainCanvas.ActualHeight * 1.1;
            MainCanvas.Width = MainCanvas.ActualWidth * 1.1;

        }

        private void Btn_inc_Click(object sender, RoutedEventArgs e)
        {
            MainCanvas.Height = MainCanvas.ActualHeight / 1.1;
            MainCanvas.Width = MainCanvas.ActualWidth / 1.1;
        }

      
        private void MainCanvas_MouseDown(object sender, MouseButtonEventArgs e)
        {
            //if (e.ButtonState == MouseButtonState.Pressed)
            //{
            //    currentPoint = e.GetPosition(this);
            //}

            Point point = new Point(30, 30);
            Ellipse elipse = new Ellipse();
            elipse.Width = 10;
            elipse.Height = 10;
            elipse.StrokeThickness = 2;
            elipse.Stroke = Brushes.Black;
            elipse.Margin = new Thickness(point.X - 2, point.Y - 2, 0, 0);
            Background.Children.Add(elipse);
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
                segment.Stroke = distance >= 20 ? Brushes.Green : Brushes.Red;
            }
        }

        private void MainCanvas_MouseLeftButtonDown(object sender, MouseButtonEventArgs e)
        {

            
           
            if (polyline == null)
            {
                var canvas = (Canvas)sender;
                var point = e.GetPosition(canvas);
               pnts.Add(new Points(n,point.X,point.Y));
                // create new polyline
                polyline = new Polyline { Stroke = Brushes.Black, StrokeThickness = 2 };
                polyline.Points.Add(point);
                Background.Children.Add(polyline);

                // initialize current polyline segment
                segment.Stroke = Brushes.Red;
                segment.Points.Add(point);
                segment.Points.Add(point);
                Background.Children.Add(segment);
                n++;
               
            }
        }

        private void MainCanvas_MouseLeftButtonUp(object sender, MouseButtonEventArgs e)
        {
            if (polyline != null)
            {
                var canvas = (Canvas)sender;
                segment.Points[1] = e.GetPosition(canvas);

                var distance = (segment.Points[0] - segment.Points[1]).Length;

                if (distance >= 20)
                {
                    var point = e.GetPosition(canvas);
                    polyline.Points.Add(segment.Points[1]);
                    segment.Points[0] = segment.Points[1];
                    pnts.Add(new Points(n, point.X, point.Y));
                    n++;
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
            }

            catch { }

            MessageBox.Show(str);
        }
    }    
}
