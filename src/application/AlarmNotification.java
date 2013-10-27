package application;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import utils.getCPU;


public class AlarmNotification extends BroadcastReceiver {
	

   	PowerManager pm;
   	getCPU cpu = new getCPU();
   	String cpuLoad = new String("CPULoad");
   	String cpuCore = new String("CPUCore");
   	String ram = new String("EnableRam");
	String MY_PREF = new String("MY_PREFS");
	Boolean prefCpuLoad;
    Boolean prefCpuCore;
    Boolean prefRam;
    Long when = getCPU.when;

    
 @Override
 public void onReceive(Context context, Intent intent) {
	 
	 //Toast.makeText(context, "active", Toast.LENGTH_SHORT).show();
	
   pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
  if(pm.isScreenOn())
  {
	  asynctask test = new asynctask(context);
	  test.execute();
  }

}
}