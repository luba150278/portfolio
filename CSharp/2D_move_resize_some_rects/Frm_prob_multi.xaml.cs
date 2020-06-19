using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;

namespace GoToKnit_
{
	/// <summary>
	/// Логика взаимодействия для Frm_prob_multi.xaml
	/// </summary>
	public partial class Frm_prob_multi : Window
	{
		public Frm_prob_multi()
		{
			InitializeComponent();
		}
		private List<Rectangle> Rectangles;
		private enum HitType
		{
			None, Body, UL, UR, LR, LL, L, R, T, B
		};

		// The part of the rectangle under the mouse.
		private HitType MouseHitType = HitType.None;

		// The Rectangle that was hit.
		private Rectangle HitRectangle = null;

		// True if a drag is in progress.
		private bool DragInProgress = false;

		// The drag's last point.
		private Point LastPoint;

		private HitType SetHitType(Rectangle rect, Point point)
		{
			//Point p = canvas_1.TranslatePoint(new Point(0, 0), rect);
			//double left = -p.X;
			//double top = -p.Y;
			//if (rect == null) return HitType.None;
			double left = Canvas.GetLeft(rect);
			double top = Canvas.GetTop(rect);
			double right = left + rect.Width;
			double bottom = top + rect.Height;

			if (point.X < left) return HitType.None;
			if (point.X > right) return HitType.None;
			if (point.Y < top) return HitType.None;
			if (point.Y > bottom) return HitType.None;


			const double GAP = 10;
			if (point.X - left < GAP)
			{
				// Left edge.
				if (point.Y - top < GAP) return HitType.UL;
				if (bottom - point.Y < GAP) return HitType.LL;
				return HitType.L;
			}
			else if (right - point.X < GAP)
			{
				// Right edge.
				if (point.Y - top < GAP) return HitType.UR;
				if (bottom - point.Y < GAP) return HitType.LR;
				return HitType.R;
			}
			if (point.Y - top < GAP) return HitType.T;
			if (bottom - point.Y < GAP) return HitType.B;
			return HitType.Body;
		}

		// Set a mouse cursor appropriate for the current hit type.
		private void SetMouseCursor()
		{
			// See what cursor we should display.
			Cursor desired_cursor = Cursors.Arrow;
			switch (MouseHitType)
			{
				case HitType.None:
					desired_cursor = Cursors.Arrow;
					break;
				case HitType.Body:
					desired_cursor = Cursors.ScrollAll;
					break;
				case HitType.UL:
				case HitType.LR:
					desired_cursor = Cursors.SizeNWSE; //курсор под углом (северо-запад/юго-восток) 
					break;
				case HitType.LL:
				case HitType.UR:
					desired_cursor = Cursors.SizeNESW;//наклон северо-восток/юго-запад
					break;
				case HitType.T:
				case HitType.B:
					desired_cursor = Cursors.SizeNS;//верхниз
					break;
				case HitType.L:
				case HitType.R:
					desired_cursor = Cursors.SizeWE;//право/лево
					break;
			}

			// Display the desired cursor.
			if (Cursor != desired_cursor) Cursor = desired_cursor;
		}

		private void canvas_1_MouseDown(object sender, MouseButtonEventArgs e)
		{
			FindHit(Mouse.GetPosition(canvas_1));		
			

			if (MouseHitType == HitType.None) return;


			LastPoint = Mouse.GetPosition(canvas_1);
			DragInProgress = true;

		}

		private void canvas_1_MouseMove(object sender, MouseEventArgs e)
		{

			if (DragInProgress)
			{
				// See how much the mouse has moved.
				Point point = Mouse.GetPosition(canvas_1);
				
				double offset_x = point.X - LastPoint.X;
				double offset_y = point.Y - LastPoint.Y;
				
				// Get the rectangle's current position.
				double new_x = Canvas.GetLeft(HitRectangle);
				double new_y = Canvas.GetTop(HitRectangle);
				//double new_x = LastPoint.X;
				//double new_y = LastPoint.Y;

				double new_width = HitRectangle.Width;
				double new_height = HitRectangle.Height;

				// Update the rectangle.
				switch (MouseHitType)
				{
					case HitType.Body:
						new_x += offset_x;
						new_y += offset_y;
						break;
					case HitType.UL:
						new_x += offset_x;
						new_y += offset_y;
						new_width -= offset_x;
						new_height -= offset_y;
						break;
					case HitType.UR:
						new_y += offset_y;
						new_width += offset_x;
						new_height -= offset_y;
						break;
					case HitType.LR:
						new_width += offset_x;
						new_height += offset_y;
						break;
					case HitType.LL:
						new_x += offset_x;
						new_width -= offset_x;
						new_height += offset_y;
						break;
					case HitType.L:
						new_x += offset_x;
						new_width -= offset_x;
						break;
					case HitType.R:
						new_width += offset_x;
						break;
					case HitType.B:
						new_height += offset_y;
						break;
					case HitType.T:
						new_y += offset_y;
						new_height -= offset_y;
						break;
				}

				// Don't use negative width or height.

				if ((new_width > 0) && (new_height > 0))
				{
					// Update the rectangle.
					Canvas.SetLeft(HitRectangle, new_x);
					Canvas.SetTop(HitRectangle, new_y);
					HitRectangle.Width = new_width;
					HitRectangle.Height = new_height;

					// Save the mouse's new location.
					LastPoint = point;
				}
			}
			else
			{
				FindHit(Mouse.GetPosition(canvas_1));
				//MouseHitType = SetHitType(HitRectangle, Mouse.GetPosition(canvas_1));
				SetMouseCursor();
			}
		}

		private void canvas_1_MouseUp(object sender, MouseButtonEventArgs e)
		{
			DragInProgress = false;
		}

		private void Window_Loaded(object sender, RoutedEventArgs e)
		{
			Rectangles = new List<Rectangle>();
			foreach (UIElement child in canvas_1.Children)
			{
				if (child is Rectangle) { Rectangles.Add(child as Rectangle); }
			}

			// Reverse the list so the Rectangles on top come first.
			Rectangles.Reverse();

		}

		// If the point is over any Rectangle,
		// return the Rectangle and the hit type.
		private void FindHit(Point point)
		{
			HitRectangle = null;
			MouseHitType = HitType.None;

			foreach (Rectangle rect in Rectangles)
			{
				MouseHitType = SetHitType(rect, point);
				if (MouseHitType != HitType.None)
				{
					HitRectangle = rect;
					return;
				}
			}

			// We didn't find a hit.
			return;
		}
	}
}