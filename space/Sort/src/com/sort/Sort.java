package com.sort;

public class Sort {

	public static void main(String[] args) {
		Sort sort=new Sort();
		int[] a={43,32,23,13,5};
//		sort.InsertionSort(a);
//		System.out.println("123");
//		sort.ShellSort(a);
//		sort.BubbleSort(a);
		int low=0;
		int high=a.length-1;
		sort.QuickSort(a,low,high);
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}

	}
	
	public void InsertionSort(int[] a){
		/*
		 * ֱ�Ӳ�������Straight insertion sorting���Ļ���˼�룺��Ҫ�����һ�������У�����ǰ��(n-1)[n>=2]
		 * �����Ѿ��ź�˳������Ҫ�ѵ�n�����鵽ǰ����������У�ʹ�����n����Ҳ���ź�˳��ġ���˷���ѭ����֪��ȫ���ź�˳��
		 * 
		 * ʱ�临�Ӷ�O��n^2��
		 * */
		
		int length=a.length;
		int insertnum;
		for(int i=1;i<length;i++)
		{
			insertnum=a[i];
			int j=i-1;
			for(;j>=0;j--){
				if(a[j]>insertnum){
					a[j+1]=a[j];
				}
			}
			a[j+1]=insertnum;
		}
	}

	public void ShellSort(int[] a) {
		/*
		 * ���������������
		 * ϣ������(ShellSort)���Ȱ�����������ļ�¼���зָ��Ϊ���������зֱ����ֱ�Ӳ������򣬴����������еļ�¼��������ʱ
		 * �ٶ�ȫ���¼����һ��ֱ������
		 * */
		int i,j,temp;
		int length=a.length;
		do{
			length=length/2;
			for(i=length;i<a.length;i++){
				if(a[i]<a[i-length]){
					temp=a[i];
					for(j=i-length;j>=0 && a[j]>temp;j-=length){
						a[j+length]=a[j];
					}
					a[j+length]=temp;
				}
			}
		}while(length>0);
		
	}
	
	public void BubbleSort(int[] a){
		/*
		 * ð������dubble Sort������Ҫ�����һ�����У��Ե�ǰ��δ�ź���ķ�Χ�ڵ�ȫ���������϶��¶����ڵ�������һ�ν��бȽϺ͵������ñȽϴ�������³�����С������ð��
		 * ��ÿ�����ڵ���ȽϺ������ǵ�����������Ҫ���෴ʱ���ͽ���������
		 * */
/*		for(int i=0;i<a.length;i++){
			for(int j=0;j<a.length-i-1;j++){
				if(a[j]>a[j+1]){
					int temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}*/
		
		for(int i=0;i<a.length;i++){
			int low=0;
			int high=a.length-1;
			while(low<high){
				for(int j=low;j<high;++j){
					if(a[j]>a[j+1]){
						int temp=a[j];
						a[j]=a[j+1];
						a[j+1]=temp;
					}
				}
				--high;
				for(int j=high;j>low;--j){
					if(a[j]<a[j+1]){
						int temp=a[j];
						a[j]=a[j+1];
						a[j+1]=temp;
					}
				}
				++low;
			}
			
		}
	}
	
	public void QuickSort (int[] a,int low,int high){
		/*
		 * ��������Quick Sort����
		 * 1.ѡ��һ����׼Ԫ��(һ���ǵ�һ��Ԫ�ػ������һ��Ԫ��)
		 * 2.ͨ��һ�����򽫴�����ļ�¼�ָ�ɶ����������֣�
		 *   ����һ���ֵ�Ԫ��ֵ���Ȼ�׼Ԫ��ֵС����һ���ֵ�Ԫ���ʾ���Ԫ�صĻ�׼ֵ��
		 * 3.��ʱ��׼Ԫ�������ź�������ȷλ��
		 * 4.Ȼ����������ֵļ�¼��ȡͬ���ķ���������������
		 * */
		
		if(low<high){
			Sort sort=new Sort();
			int middle=sort.getMiddle(a, low, high);
			sort.QuickSort(a, 0, middle-1);
			sort.QuickSort(a, middle+1, high);
		}
	}
	
	public int getMiddle(int[] a,int low,int high){
		int key=a[low];
		//ȡ��һ��Ԫ��Ϊ��׼Ԫ��
		while(low<high){
			for(int i=high;low<high&&a[i]>=key;high--){		
			}
			a[low]=a[high];
			for(int i=low;low<high && a[i]<=key;low++){
			}
			a[high]=a[low];
		}
		a[low]=key;
		return low;//��ʱ����˳���Ѿ��ı�
	}

}