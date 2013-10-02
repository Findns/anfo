package cpu.only;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;
import android.util.Log;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;




class SystemUtils extends Activity{
  private static final String BOGOMIPS_PATTERN = "BogoMIPS[\\s]*:[\\s]*(\\d+\\.\\d+)[\\s]*\n";
  private static final String MEMTOTAL_PATTERN = "MemTotal[\\s]*:[\\s]*(\\d+)[\\s]*kB\n";
  private static final String MEMFREE_PATTERN = "MemFree[\\s]*:[\\s]*(\\d+)[\\s]*kB\n";
  
  float core1 = 0;
  float core2 = 0;
  float core3 = 0;
  float core4 = 0;

  public float readUsage() {
	    try {
	    	
	        RandomAccessFile reader = new RandomAccessFile("/proc/stat", "r");
	        String load = reader.readLine();
	        

	        String[] toks = load.split(" ");

	        long idle1 = Long.parseLong(toks[5]);
	        long cpu1 = Long.parseLong(toks[2]) + Long.parseLong(toks[3]) + Long.parseLong(toks[4])
	              + Long.parseLong(toks[6]) + Long.parseLong(toks[7]) + Long.parseLong(toks[8]);

	        try {
	            Thread.sleep(360);
	        } catch (Exception e) {}

	        reader.seek(0);
	        load = reader.readLine();
	        reader.close();

	        toks = load.split(" ");

	        long idle2 = Long.parseLong(toks[5]);
	        long cpu2 = Long.parseLong(toks[2]) + Long.parseLong(toks[3]) + Long.parseLong(toks[4])
	            + Long.parseLong(toks[6]) + Long.parseLong(toks[7]) + Long.parseLong(toks[8]);

	        return (float)(cpu2 - cpu1) / ((cpu2 + idle2) - (cpu1 + idle1));

	    } catch (IOException ex) {
	        ex.printStackTrace();
	    }

	    return 0;
	} 
  
  
  public  int getCPUMaxOfCoreAllowed() throws Exception {
	   
	   File f = new File("/sys/kernel/debug/tegra_hotplug/max_cpus");
	   if(f.exists()) 
	   {

		   int temp = SystemUtils.readSystemFileAsInt("/sys/kernel/debug/tegra_hotplug/max_cpus");
		   if (temp > 0)
		   {
			   return temp;
		   }

	   }
	   return 0;
	  }
  
  
  public float readUsageCPU0() {
	    try {
	    	
	        RandomAccessFile reader = new RandomAccessFile("/proc/stat", "r");
	        reader.seek(0);
	        String load;
	        String[] toks;
    	long total1 = 0;
    	long user1 = 0;
    	long systeme1 = 0;
    	long total2 = 0;
    	long user2 = 0;
    	long systeme2 = 0;
    	
    	long total3 = 0;
    	long user3 = 0;
    	long systeme3 = 0;
    	long total4 = 0;
    	long user4 = 0;
    	long systeme4 = 0;
    	
    	long total5 = 0;
    	long user5 = 0;
    	long systeme5 = 0;
    	long total6 = 0;
    	long user6 = 0;
    	long systeme6= 0;
    	

    	long total7 = 0;
    	long user7 = 0;
    	long systeme7 = 0;
    	long total8 = 0;
    	long user8 = 0;
    	long systeme8 = 0;

	        while((load = reader.readLine()) != null)
	        {
	        	if(load.startsWith("cpu0"))
	        	{
			        toks = load.trim().split("[ ]+");
		
			        total1 = Long.parseLong(toks[1])+Long.parseLong(toks[2])+Long.parseLong(toks[3])+
			        		+Long.parseLong(toks[4])+Long.parseLong(toks[5])+Long.parseLong(toks[6])+Long.parseLong(toks[7]);
			        
			        user1 = Long.parseLong(toks[1]) + Long.parseLong(toks[2]);
			        
			        systeme1 = Long.parseLong(toks[3]) + Long.parseLong(toks[6]) +Long.parseLong(toks[7]);
			        
	        	}
	        	
	        	if(load.startsWith("cpu1"))
	        	{
			        toks = load.trim().split("[ ]+");
		
			        total3 = Long.parseLong(toks[1])+Long.parseLong(toks[2])+Long.parseLong(toks[3])+
			        		+Long.parseLong(toks[4])+Long.parseLong(toks[5])+Long.parseLong(toks[6])+Long.parseLong(toks[7]);
			        
			        user3 = Long.parseLong(toks[1]) + Long.parseLong(toks[2]);
			        
			        systeme3 = Long.parseLong(toks[3]) + Long.parseLong(toks[6]) +Long.parseLong(toks[7]);
			        
	        	}
	        	
	        	if(load.startsWith("cpu2"))
	        	{
			        toks = load.trim().split("[ ]+");
		
			        total5 = Long.parseLong(toks[1])+Long.parseLong(toks[2])+Long.parseLong(toks[3])+
			        		+Long.parseLong(toks[4])+Long.parseLong(toks[5])+Long.parseLong(toks[6])+Long.parseLong(toks[7]);
			        
			        user5 = Long.parseLong(toks[1]) + Long.parseLong(toks[2]);
			        
			        systeme5 = Long.parseLong(toks[3]) + Long.parseLong(toks[6]) +Long.parseLong(toks[7]);
			        
	        	}
	        	
	        	
	        	if(load.startsWith("cpu3"))
	        	{
			        toks = load.trim().split("[ ]+");
		
			        total7 = Long.parseLong(toks[1])+Long.parseLong(toks[2])+Long.parseLong(toks[3])+
			        		+Long.parseLong(toks[4])+Long.parseLong(toks[5])+Long.parseLong(toks[6])+Long.parseLong(toks[7]);
			        
			        user7 = Long.parseLong(toks[1]) + Long.parseLong(toks[2]);
			        
			        systeme7 = Long.parseLong(toks[3]) + Long.parseLong(toks[6]) +Long.parseLong(toks[7]);
			        
	        	}
			        
	        }
	        
	        //--------WAIT---------------------------------------------------------------------------------------------
			        try {
			            Thread.sleep(360);
			        } catch (Exception e) {}
			        
			        
			        
		
			        reader.seek(0);

			        while((load = reader.readLine()) != null)
			        {
			        	if(load.startsWith("cpu0"))
			        	{
					        toks = load.trim().split("[ ]+");
				
					        total2 = Long.parseLong(toks[1])+Long.parseLong(toks[2])+Long.parseLong(toks[3])+
					        		+Long.parseLong(toks[4])+Long.parseLong(toks[5])+Long.parseLong(toks[6])+Long.parseLong(toks[7]);
					        
					        user2 = Long.parseLong(toks[1]) + Long.parseLong(toks[2]);
					        
					        systeme2 = Long.parseLong(toks[3]) + Long.parseLong(toks[6]) +Long.parseLong(toks[7]);
			        	}
			        	
			        	if(load.startsWith("cpu1"))
			        	{
					        toks = load.trim().split("[ ]+");
				
					        total4 = Long.parseLong(toks[1])+Long.parseLong(toks[2])+Long.parseLong(toks[3])+
					        		+Long.parseLong(toks[4])+Long.parseLong(toks[5])+Long.parseLong(toks[6])+Long.parseLong(toks[7]);
					        
					        user4 = Long.parseLong(toks[1]) + Long.parseLong(toks[2]);
					        
					        systeme4 = Long.parseLong(toks[3]) + Long.parseLong(toks[6]) +Long.parseLong(toks[7]);
					        
			        	}
			        	
			        	if(load.startsWith("cpu2"))
			        	{
					        toks = load.trim().split("[ ]+");
				
					        total6 = Long.parseLong(toks[1])+Long.parseLong(toks[2])+Long.parseLong(toks[3])+
					        		+Long.parseLong(toks[4])+Long.parseLong(toks[5])+Long.parseLong(toks[6])+Long.parseLong(toks[7]);
					        
					        user6 = Long.parseLong(toks[1]) + Long.parseLong(toks[2]);
					        
					        systeme6 = Long.parseLong(toks[3]) + Long.parseLong(toks[6]) +Long.parseLong(toks[7]);
					        
			        	}
			        	
			        	
			        	if(load.startsWith("cpu3"))
			        	{
					        toks = load.trim().split("[ ]+");
				
					        total8 = Long.parseLong(toks[1])+Long.parseLong(toks[2])+Long.parseLong(toks[3])+
					        		+Long.parseLong(toks[4])+Long.parseLong(toks[5])+Long.parseLong(toks[6])+Long.parseLong(toks[7]);
					        
					        user8 = Long.parseLong(toks[1]) + Long.parseLong(toks[2]);
					        
					        systeme8 = Long.parseLong(toks[3]) + Long.parseLong(toks[6]) +Long.parseLong(toks[7]);
					        
			        	}
			        }
			        reader.close();
			        
			        long x = 100L * ((user2-user1) + (systeme2-systeme1));
			        long y = (total2-total1);
			        long z = 0;
			        if(y > 0)
			        {
			        	z = (x/y);
			        }
			        else
			        {
			        	z = 0;
			        }
			        this.core1 = (float)z;
			        
			        long a = 100L * ((user4-user3) + (systeme4-systeme3));
			        long b = (total4-total3);
			        long c = 0;
			        
			        if(b > 0)
			        {
			        	c = (a/b);
			        }
			        else
			        {
			        	c = 0;
			        }
			        this.core2 = (float)c;
			        
			        
			        long d = 100L * ((user6-user5) + (systeme6-systeme5));
			        long e = (total6-total5);
			        long f = 0;
			        if(e > 0)
			        {
			        	f = (d/e);
			        }
			        else
			        {
			        	f = 0;
			        }
			        this.core3 = (float)f;
			        
			        
			        long g = 100L * ((user8-user7) + (systeme8-systeme7));
			        long h = (total8-total7);
			        long i = 0;
			        if(h > 0)
			        {
			        	i = (g/h);
			        }
			        else
			        {
			        	i = 0;
			        }
			        this.core4 = (float)i;
			        
			        
		
			        return this.core1;


	    } catch (IOException ex) {
	        ex.printStackTrace();
	    }
	    
	    return 0;
	} 



public float readUsageCPU1() {

	    return this.core2;
	}



public float readUsageCPU2() {

	    return this.core3;
	}



public float readUsageCPU3() {
	    return this.core4;
	}
  
  

  
  
  
  public int getNumOfCpus() {

	    class CPUFilter implements FileFilter {
	        public boolean accept(File pathname) {
	            // Check if filename is "cpu0", "cpu1,...
	            if (Pattern.matches("cpu[0-9]", pathname.getName())) {
	                return true;
	            }
	            return false;
	        }
	    }

	    try {
	        // Get directory containing CPU info
	        File dir = new File("/sys/devices/system/cpu/");
	        File[] files = dir.listFiles(new CPUFilter());
	        // Return the number of cores 
	        return files.length;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return 1;
	    }

	}
  
  
  
  	public int[] getCpuUsageStatistic() {

	    String tempString = executeTop();

	    tempString = tempString.replaceAll(",", "");
	    tempString = tempString.replaceAll("User", "");
	    tempString = tempString.replaceAll("System", "");
	    tempString = tempString.replaceAll("IOW", "");
	    tempString = tempString.replaceAll("IRQ", "");
	    tempString = tempString.replaceAll("%", "");
	    for (int i = 0; i < 10; i++) {
	        tempString = tempString.replaceAll("  ", " ");
	    }
	    tempString = tempString.trim();
	    String[] myString = tempString.split(" ");
	    int[] cpuUsageAsInt = new int[myString.length];
	    for (int i = 0; i < myString.length; i++) {
	        myString[i] = myString[i].trim();
	        cpuUsageAsInt[i] = Integer.parseInt(myString[i]);
	    }
	    return cpuUsageAsInt;
	}

  	public String executeTop() {
	    java.lang.Process p = null;
	    BufferedReader in = null;
	    String returnString = null;
	    try {
	        p = Runtime.getRuntime().exec("top -n 1");
	        in = new BufferedReader(new InputStreamReader(p.getInputStream()));
	        while (returnString == null || returnString.contentEquals("")) {
	            returnString = in.readLine();
	        }
	    } catch (IOException e) {
	        Log.e("executeTop", "error in getting first line of top");
	        e.printStackTrace();
	    } finally {
	        try {
	            in.close();
	            p.destroy();
	        } catch (IOException e) {
	            Log.e("executeTop",
	                    "error in closing and destroying top process");
	            e.printStackTrace();
	        }
	    }
	    return returnString;
	}
  
  
	public int getNumProcesses(Context context)
  {
      ActivityManager servMng = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
      List<ActivityManager.RunningAppProcessInfo> list = servMng.getRunningAppProcesses();
      return list.size();
  }
  
  
 

	  public void setMaxCoreAllowed(int core)
	  {

	        Process localProcess;
			try {
				localProcess = Runtime.getRuntime().exec("su");
				DataOutputStream localDataOutputStream = new DataOutputStream(localProcess.getOutputStream());
		        localDataOutputStream.writeBytes("mount -o rw,remount -t yaffs2  /dev/block/mtdblock03 /sys\n");
		        localDataOutputStream.flush();
		        localDataOutputStream.writeBytes("chmod 777 /sys/kernel/debug/tegra_hotplug/max_cpus\n");
		        localDataOutputStream.flush();
		        localDataOutputStream.writeBytes("echo '" + core + "' > /sys/kernel/debug/tegra_hotplug/max_cpus\n");
		        localDataOutputStream.flush();
		        localDataOutputStream.writeBytes("exit \n");
		        localDataOutputStream.flush();
		        
		        try {
					localProcess.waitFor();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	  }
   
  
  public  int getCPUFrequencyMax() throws Exception {
    return SystemUtils.readSystemFileAsInt("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq");
  }
   
  public  int getCPUTemp() throws Exception {
	   
	   File f = new File("/sys/devices/virtual/thermal/thermal_zone0/temp");
	   if(f.exists()) 
	   {

		   int temp = SystemUtils.readSystemFileAsInt("/sys/devices/virtual/thermal/thermal_zone0/temp");
		   if (temp > 3)
		   {
			   return temp;
		   }

	   }
	   return 0;
	  }
  
  public  float getCPUTempHTC() throws Exception {
	   
	   
	   File f = new File("/sys/htc/cpu_temp");
	   if(f.exists()) 
	   {
	   
		   float temp = SystemUtils.readSystemFileAsFloat("/sys/htc/cpu_temp");
		   if (temp > 3)
		   {
			   return temp;
		   } 

	   }
	   return 0;
	  }
  
  
public  int getCPUTempTegra() throws Exception {
	   
	   
	   File f = new File("/sys/kernel/debug/tegra_thermal/temp_tj");
	   if(f.exists()) 
	   {
	   
		   int temp = SystemUtils.readSystemFileAsInt("/sys/kernel/debug/tegra_thermal/temp_tj");
		   if (temp > 3)
		   {
               temp /= 1000;
			   return temp;
		   } 

	   }
	   return 0;
	  }
	  
	  
	  public  int getCPUTempGalaxyS3() throws Exception {
		   
		   
		   File f = new File("/sys/devices/platform/s5p-tmu/temperature");
		   if(f.exists()) 
		   {
		   
			   int temp = SystemUtils.readSystemFileAsInt("/sys/devices/platform/s5p-tmu/temperature");
			   if (temp > 3)
			   {
				   return temp;
			   } 

		   }
		   return 0;
		  }


 
 public  int getActiveCore() throws Exception {
	  
	  File f = new File("/sys/devices/system/cpu/cpu_on");
	   if(f.exists()) 
	   {
	   
		   int ActiveCore = SystemUtils.readSystemFileAsInt("/sys/devices/system/cpu/cpu_on");
		   if (ActiveCore > 0)
		   {
			   return ActiveCore;
		   } 

	   }
	   return 0;
	  
	  }
 
 public  int getMaxActiveCore() throws Exception {
	    return SystemUtils.readSystemFileAsInt("/sys/devices/system/cpu/kernel_max");
	  }
 
 public  int getCPUFrequencyMin() throws Exception {
	    return SystemUtils.readSystemFileAsInt("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq");
	  }
 
 public  int getCPU0FrequencyCurrentNormaleWay() throws Exception {
	  
	  File f = new File("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq");
	   if(f.exists()) 
	   {
	   
		   int Active = SystemUtils.readSystemFileAsInt("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq");
		   if (Active > 0)
		   {
			   return Active;
		   } 

	   }
	   return 0;
	  }
  
  
public  int getCPU0FrequencyCurrentCustomWay() throws Exception {
	  
	  File f = new File("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_cur_freq");
	   if(f.exists()) 
	   {
	   
		   int Active = SystemUtils.readSystemFileAsInt("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_cur_freq");
		   if (Active > 0)
		   {
			   return Active;
		   } 

	   }
	   return 0;
	  }
  
  
  
  
  
  
  public  int getCPU1FrequencyCurrent() throws Exception {
	    return SystemUtils.readSystemFileAsInt("/sys/devices/system/cpu/cpu1/cpufreq/scaling_cur_freq");
	  }
  
  public  int getCPU2FrequencyCurrent() throws Exception {
	    return SystemUtils.readSystemFileAsInt("/sys/devices/system/cpu/cpu2/cpufreq/scaling_cur_freq");
	  }
  
  public  int getCPU3FrequencyCurrent() throws Exception {
	    return SystemUtils.readSystemFileAsInt("/sys/devices/system/cpu/cpu3/cpufreq/scaling_cur_freq");
	  }
  
  
  
  public  int getMemoryTotal() throws Exception {
	  final MatchResult matchResult = SystemUtils.matchSystemFile("/proc/meminfo", MEMTOTAL_PATTERN, 1000);

	  try {
	    if(matchResult.groupCount() > 0) {
	      return Integer.parseInt(matchResult.group(1))/1000;
	    } else {
	      throw new Exception();
	    }
	  } catch (final NumberFormatException e) {
	    throw new Exception(e);
	  }
	}

	  
  //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  
  private boolean isMyServiceRunning() {
	    ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
	    for (RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
	        if ("com.example.MyService".equals(service.service.getClassName())) {
	            return true;
	        }
	    }
	    return false;
	}


  
  
  
  private static int readSystemFileAsInt(final String pSystemFile) throws Exception {
    InputStream in = null;
    try {
      final Process process = new ProcessBuilder(new String[] { "/system/bin/cat", pSystemFile }).start();

      in = process.getInputStream();
      final String content = readFully(in);
      return Integer.parseInt(content);
    } catch (final Exception e) {
      throw new Exception(e);
    } 
  }
  
  private static Float readSystemFileAsFloat(final String pSystemFile) throws Exception {
	    InputStream in = null;
	    try {
	      final Process process = new ProcessBuilder(new String[] { "/system/bin/cat", pSystemFile }).start();

	      in = process.getInputStream();
	      final String content = readFully(in);
	      return Float.parseFloat(content);
	    } catch (final Exception e) {
	      throw new Exception(e);
	    } 
	  }
  
  public static final String readFully(final InputStream pInputStream) throws IOException {
    final StringBuilder sb = new StringBuilder();
    final Scanner sc = new Scanner(pInputStream);
    while(sc.hasNextLine()) {
      sb.append(sc.nextLine());
    }
    return sb.toString();
  }
  private static MatchResult matchSystemFile(final String pSystemFile, final String pPattern, final int pHorizon) throws Exception {
    InputStream in = null;
    try {
      final Process process = new ProcessBuilder(new String[] { "/system/bin/cat", pSystemFile }).start();

      in = process.getInputStream();
      final Scanner scanner = new Scanner(in);

      final boolean matchFound = scanner.findWithinHorizon(pPattern, pHorizon) != null;
      if(matchFound) {
        return scanner.match();
      } else {
        throw new Exception();
      }
    } catch (final IOException e) {
      throw new Exception(e);
    } 
      
  }
}