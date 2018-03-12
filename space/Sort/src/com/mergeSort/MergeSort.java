package com.mergeSort;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
 * �鲢���� �ݹ�
 * ����������������������ϲ���һ���µ��������
 * ���Ѵ���������з�Ϊ���ɸ������У�ÿ��������������ģ�
 * Ȼ���ٰ����������кϲ�Ϊ������������
 * */
public class MergeSort {
	
	public void mergesort(int[] a,int low,int high){
		int mid=(low+high)/2;
		if(low<high){
			mergesort(a, low, mid);
			mergesort(a, mid+1, high);
			
			System.out.println("low= "+low);
			System.out.println("high= "+high);
			//�ݹ������ �ϲ�
			merge(a,low,mid,high);
		}
	}
	
	private void merge(int[] a, int low, int mid, int high) {
		int[] temp=new int[high-low+1];
		int i=low;//��ָ��
		int j=mid+1;//��ָ��
		int k=0;
		//�ѽ�С�������Ƶ���������
		while(i<mid && j<=high){
			if(a[i]<a[j]){
				temp[k++]=a[i++];
			}else{
				temp[k++]=a[j++];
			}
		}
		
		//�����ʣ�������������
		while(i<=mid){
			temp[k++]=a[i++];
		}
		
		//���ұ�ʣ�������������
		while(j<=high){
			temp[k++]=a[j++];
		}
		
		//���������е�������nums����
		for(int k2=0;k2<temp.length;k2++){
			a[k2+low]=temp[k2];
		}
		
	}

	public static void main(String[] args){
		int[] a={51,46,20,18,65,97,82,30,77,50};
		MergeSort m=new MergeSort();
		m.mergesort(a,0,a.length-1);
//		m.merge(a, 0, (0+a.length-1)/2, a.length-1);
		System.out.println(Arrays.toString(a));
		
	}
}