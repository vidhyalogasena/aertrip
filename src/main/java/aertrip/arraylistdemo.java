package aertrip;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class arraylistdemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

ArrayList<Integer> alist = new ArrayList<Integer>();
alist.add(3);
alist.add(3);
alist.add(0);
alist.add(3);
alist.add(0);
alist.add(3);
alist.add(3);
alist.add(3);
alist.add(3);
alist.add(3);
alist.add(2);
alist.add(1);
alist.add(1);
alist.add(4);
alist.add(5);
alist.add(0);

System.out.println(alist.size());
System.out.println("Before sorting:"+alist);
Collections.sort(alist);
System.out.println("Sored list:"+alist);
Integer min=alist.get(0);

System.out.println("minimum value:"+min);

while(alist.contains(min))

{
	alist.remove(min);
}
System.out.println(alist.size());
int secmin=alist.get(0);
System.out.println(secmin);

/*int min=Collections.min(alist);
for(int ar=0;ar<alist.size();ar++)
{
	if(alist.get(ar)==0)
	{
		min=alist.get(ar);
		System.out.println(min);
		alist.remove(ar);
	
	}

}
Collections.sort(alist);
System.out.println("Revised sort:"+alist);

int secmin=alist.get(0);
System.out.println("Second minimum is:"+secmin);
/*int min=alist.indexOf(0);


for(int i=0;i<alist.size();i++)

{
	if(alist.get(i)<min)
	{
		
		min=alist.get(i);
		
	
	}

}
int secmin=alist.indexOf(0);
for(int i=0;i<alist.size();i++)
{
	if(alist.get(i)<secmin && alist.get(i)!=min )
	{
		secmin=alist.get(i);
	}
}*/
	
	//System.out.println("SecondSmallest is:"+secmin);
	
	}

	

}
