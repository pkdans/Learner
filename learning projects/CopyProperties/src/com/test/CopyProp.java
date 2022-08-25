package com.test;

import java.lang.reflect.Field;

public class CopyProp {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A s = new A("Pijus", null);
		A t = new A("Rahul", "26");
		System.out.println(s.toString());
		System.out.println(t.toString());
		copyProperties(s, t,false);
		System.out.println();
		System.out.println(s.toString());
		System.out.println(t.toString());
	}
	public static void copyProperties(Object src, Object dist,boolean copyNull) {
		Class cs = src.getClass();
		Class classDist = dist.getClass();
		
		Field fields[] = cs.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
            Field filed = fields[i];
            filed.setAccessible(true);//

            try {
                Object srcValue = filed.get(src);
                String fieldName = filed.getName();

                //Field distField = classDist.getField(fieldName);//public feld
                Field distField = classDist.getDeclaredField(fieldName);//all field
                distField.setAccessible(true);
                if (srcValue == null) {
                    if (copyNull) {
                        distField.set(dist, null);
                    }
                } else {
                    distField.set(dist, srcValue);
                }

            } catch (Exception e) {
            }
        }
	}

}
class A{
	private String name;
	private String roll;
	
	public A(String name, String roll) {
		super();
		this.name = name;
		this.roll = roll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRoll() {
		return roll;
	}
	public void setRoll(String roll) {
		this.roll = roll;
	}
	@Override
	public String toString() {
		return "A [name=" + name + ", roll=" + roll + "]";
	}
	
}