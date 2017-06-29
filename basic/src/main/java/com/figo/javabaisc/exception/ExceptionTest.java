package com.figo.javabaisc.exception;

/**
 * Created by 50245 on 2017/6/29.
 */
public class ExceptionTest {
    public static void main(String[] args) throws Exception{
        // TODO Auto-generated method stub
        int[] date1= {1,2,3,4,5,6};
        int[] date2= {6,1,3,5,0,3};

        cal(date1,date2);
    }

    public static void cal(int[] date1,int[] date2)throws Exception
    {
        for(int i = 0; i<date1.length; i++)
        {
            try
            {
                System.out.println(date1[i] + "/" + date2[i] + " = " + date1[i]/date2[i]);
            }catch(Exception ex)
            {
                System.out.println("发生异常");
                System.out.println(ex.getLocalizedMessage());
                //throw ex;
                //continue;
            }
        }
    }

}
