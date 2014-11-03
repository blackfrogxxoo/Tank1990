package org.wxc.tank1990;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements Callback, Runnable{
	//引入的元素有battlecity.png,selecttank.gif,声音用hit.wav
	
	MainActivity mainActivity;
	Canvas canvas;// 在draw方法中实例化
	Thread thread;
	Paint paint;
	int screenW, screenH;
	int bitX, bitY;
	SurfaceHolder surfaceHolder;
	private Bitmap shoubing;
	public GameView(Context context) {
		super(context);
		thread = new Thread(this);

		surfaceHolder = this.getHolder();
		surfaceHolder.addCallback(this);// 添加Callback

		paint = new Paint();
		paint.setAntiAlias(true);
		paint.setTextSize(30);
		paint.setColor(Color.WHITE);
		this.setKeepScreenOn(true);

		shoubing = BitmapFactory.decodeResource(getResources(),
				R.drawable.shoubing);
		

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
			shoubing = Bitmap.createScaledBitmap(shoubing,screenW,screenH-screenW,true);//横向填满屏幕
			bitX = shoubing.getWidth();
			bitY = shoubing.getHeight();
			System.out.println("Width:" + bitX + " Height:" + bitY);
			canvas = surfaceHolder.lockCanvas();// 得到一个canvas实例
			// canvas.drawColor(Color.WHITE);
			shoubing.prepareToDraw();
			canvas.drawBitmap(shoubing, (screenW-bitX)/2, screenH-bitY, null);
			
		} catch (Exception e) {

		} finally {
			if (canvas != null)
				surfaceHolder.unlockCanvasAndPost(canvas);// 将画好的画布提交
		}
	}

	@Override
	public void run() {
		
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		screenW = this.getWidth();
		screenH = this.getHeight();
		System.out.println("Width:" + screenW + " Height:" + screenH);
		draw();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		
	}

}
