using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;
using System.Windows.Shapes;
using static System.Convert;


namespace GoToKnit_
{
	/// <summary>
	/// Логика взаимодействия для Frm_editor.xaml
	/// </summary>
	public partial class Frm_editor : Window
	{
		public Frm_editor()
		{
			InitializeComponent();
			UpdateBackPattern(null, null);
		}

        void UpdateBackPattern(object sender, SizeChangedEventArgs e)
        {
            var w = Background.ActualWidth;
            double h = Background.ActualHeight;
            
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
                AddLineToBackground(x, 0, x, h,z);
                z = 1;
            }
            for (int y = ToInt32(h); y > 0; y -= 10)
            {
                if (y % 100 == 0)
                {
                    z = 2;
                    Tb_forline(((ToInt32(h)-y) / 10).ToString(), false, -20, y, Colors.Purple);
                    Tb_forline(((ToInt32(h)-y) / 10).ToString(), false, w, y, Colors.Purple);

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
            MainCanvas.Children.Add(tb);
        }
    }
}
