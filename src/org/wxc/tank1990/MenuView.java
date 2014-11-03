package org.wxc.tank1990;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.animation.Animation;

public class MenuView extends SurfaceView implements Callback, Runnable {
	// 引入的元素有battlecity.png,selecttank.gif,声音用hit.wav
	MainActivity mainActivity;
	Canvas canvas;// 在draw方法中实例化
	Thread thread;
	Paint paint;
	int ScreenW, ScreenH;
	int bitX, bitY;
	SurfaceHolder surfaceHolder;
	private Bitmap menuBit;

	public MenuView(Context context) {
		super(context);
		thread = new Thread(this);

		surfaceHolder = this.getHolder();
		surfaceHolder.addCallback(this);// 添加Callback

		paint = new Paint();
		paint.setAntiAlias(true);
		paint.setTextSize(30);
		paint.setColor(Color.WHITE);
		this.setKeepScreenOn(true);

		menuBit = BitmapFactory.decodeResource(getResources(),
				R.drawable.battlecity);
		bitX = menuBit.getWidth();
		bitY = -100;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		return super.onKeyDown(keyCode, event);
	}

	public void draw() {
		try {
			canvas = surfaceHolder.lockCanvas();// 得到一个canvas实例
			// canvas.drawColor(Color.WHITE);
			menuBit.prepareToDraw();
			canvas.drawBitmap(menuBit, (ScreenW - bitX) / 2, bitY, paint);
			canvas.drawText("1P     Game start", ScreenW / 3, ScreenH / 2,
					paint);
			canvas.drawText("2P     Game start", ScreenW / 3, ScreenH / 2 + 40,
					paint);
		} catch (Exception e) {

		} finally {
			if (canvas != null)
				surfaceHolder.unlockCanvasAndPost(canvas);// 将画好的画布提交
		}
	}

	@Override
	public void run() {
		while (true) {
			draw();
			if (bitY < (ScreenW - bitX) / 2)
				bitY += 1;
			try {
				// System.out.println("Menu View running");
				Thread.sleep(10);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void startAnimation(Animation animation) {
		super.startAnimation(animation);
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		System.out.println("Menu View created!");
		ScreenW = this.getWidth();
		ScreenH = this.getHeight();
		System.out.println("Width:" + ScreenW + " Height:" + ScreenH);
		thread.start();

	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub

	}

}
