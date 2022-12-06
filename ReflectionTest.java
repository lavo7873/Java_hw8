// Lam Vinh Vong


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class ReflectionTest {

    public static void main(String[] args) {
        //Print out all methods declared in class Person (notice, declared methods only), including the
        //number of input parameters and all input parameter types.
        Person p = new Person("Lam", "Vong", 25, "555",
                new Address(1, "LV", "San Jose", "95132", "CA"));
        System.out.println("\nPerson class methods:");
        Method[] personMethod = p.getClass().getDeclaredMethods();
        for (Method method : personMethod) {
            String methodName = method.getName();
            Class[] parameters = method.getParameterTypes();

            if (parameters.length == 0) {
                System.out.println(methodName + "() has 0 parameter");
            } else {
                System.out.println(methodName + "() has " + parameters.length + " parameter(s) of the following types");
            }
            for (Class pa : parameters) {
                System.out.println("\t" + pa.getName());
            }
        }
        System.out.println("");

        //Print out all methods available to class Address (notice, all methods), including the number
        //of input parameters and all input parameter types
        Address a = new Address(8, "MR", "SJ", "95132", "CA");
        System.out.println("\nAddress class methods:");
        Method[] addressMethod = a.getClass().getDeclaredMethods();
        for (Method method : addressMethod) {
            String methodName = method.getName();
            Class[] parameters = method.getParameterTypes();

            if (parameters.length == 0) {
                System.out.println(methodName + "() has 0 parameter");
            } else {
                System.out.println(methodName + "() has " + parameters.length + " parameter(s) of the following types");
            }
            for (Class pa : parameters) {
                System.out.println("\t" + pa.getName());
            }
        }
        System.out.println("");

        //Print out all fields declared in class Address (notice, declared fields only), including the
        //access modifier and the type of the field.
        Address a1 = new Address(8, "MR", "SJ", "95132", "CA");
        System.out.println("\nAddress fields:");
        Field[] addressFields = a1.getClass().getDeclaredFields();
        for (Field field : addressFields) {
            System.out.println(field.toString());
        }
        System.out.println("");

        //Instantiate 3 new instances of class Person. This should also involve instantiating the Address
        //class using reflection.
        System.out.println("Print out 3 instances of Person");
        try {
            //Instance by class forName()
            Address addressInstance = Address.class.newInstance();
            addressInstance.setStreetNum(8);
            addressInstance.setStreetName("MR");
            addressInstance.setCity("SJ");
            addressInstance.setZip("95132");
            addressInstance.setState("CA");

            Person peInstance = (Person) Class.forName("Person").newInstance();
            peInstance.setFirstName("Lam");
            peInstance.setLastName("Vong");
            peInstance.setAge(25);
            peInstance.setSsn("456789");
            peInstance.setAddress(addressInstance);

            System.out.println(peInstance.toString());

            //Instance by constructor method
            Constructor<Address> aConstructorInstance = Address.class.getConstructor(int.class, String.class, String.class, String.class, String.class);
            Address aConstructorIns = aConstructorInstance.newInstance(3, "LL", "VV", "95132", "CA");

            Constructor<Person> pConstructorInstance = Person.class.getConstructor(String.class, String.class, int.class, String.class, Address.class);
            Person pConstructorIns = pConstructorInstance.newInstance("LV", "VONG", 25, "95132", aConstructorIns);

            System.out.println(pConstructorIns.toString());


            Constructor<Address> a1ConstructorInstance = Address.class.getConstructor(int.class, String.class, String.class, String.class, String.class);
            Address a1ConstructorIns = a1ConstructorInstance.newInstance(8, "LLVV", "MMRR", "95113322", "CCAA");

            Constructor<Person> p1ConstructorInstance = Person.class.getConstructor(String.class, String.class, int.class, String.class, Address.class);
            Person p1ConstructorIns = p1ConstructorInstance.newInstance("L", "V", 25, "95132", aConstructorIns);

            System.out.println(p1ConstructorIns.toString());

            System.out.println();

            //Use Java reflection to invoke setFirstName(), setLastName() and setAge() in one or more
            //instance(s) of Person class.
            Address b = new Address(16, "MRI", "SJI", "95152", "CAI");
            Person ps = new Person("Lam", "Vong", 25, "456", b);

            System.out.println("Invoke function:");
            Class psClass = ps.getClass();

            Method setFirstNameMethod = psClass.getDeclaredMethod("setFirstName", String.class);
            setFirstNameMethod.invoke(ps, "LV");
            Method setLastNameMethod = psClass.getDeclaredMethod("setLastName", String.class);
            setLastNameMethod.invoke(ps, "MR");
            Method setAgeMethod = psClass.getDeclaredMethod("setAge", int.class);
            setAgeMethod.invoke(ps, 25);

            System.out.println("Person: " + ps.toString());

        } catch (InstantiationException e) {
            System.out.println(e);
        } catch (IllegalAccessException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (NoSuchMethodException e) {
            System.out.println(e);
        } catch (InvocationTargetException e) {
            System.out.println(e);
        }
    }
}
