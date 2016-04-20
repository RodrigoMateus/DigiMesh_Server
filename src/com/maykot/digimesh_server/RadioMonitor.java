package com.maykot.digimesh_server;

import com.digi.xbee.api.exceptions.TimeoutException;
import com.maykot.radiolibrary.utils.OpenMyDevice;

public class RadioMonitor implements Runnable {

	public RadioMonitor() {

	}

	@Override
	public void run() {
		while (true) {
			try {
				MainApp.myDevice.getPowerLevel().getValue();
			} catch (TimeoutException e1) {
				System.out.println("TimeoutException in Local Radio connection. Check connection.");
			} catch (Exception e1) {
				System.out.println("Local Radio connection has been lost. Check connection.");
				MainApp.myDevice = OpenMyDevice.open(MainApp.deviceConfig, MainApp.myDevice);
			}

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
