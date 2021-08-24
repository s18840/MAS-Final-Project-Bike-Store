package s18840;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public abstract class ObjectPlus implements Serializable {
    private static Map<Class, List<ObjectPlus>> allExtents = new Hashtable<>();

    public ObjectPlus() {
        List extent = null;
        Class theClass = this.getClass();

        if(allExtents.containsKey(theClass)) {
            // An extent of this class already exist
            extent = allExtents.get(theClass);
        }
        else {
            // An extent does not exist - create a new one
            extent = new ArrayList();
            allExtents.put(theClass, extent);
        }

        extent.add(this);
    }
    public static void writeExtents(ObjectOutputStream stream) throws IOException {
        stream.writeObject(allExtents);
    }

    public static void readExtents(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        allExtents = (Hashtable) stream.readObject();
    }

    public static void showExtent(Class theClass) throws Exception {
        List extent = null;

        if(allExtents.containsKey(theClass)) {
            // Extent of this class already exist
            extent = allExtents.get(theClass);
        }
        else {
            throw new Exception("Unknown class " + theClass);
        }

        System.out.println("Extent of the class: " + theClass.getSimpleName());

        for(Object obj : extent) {
            System.out.println(obj);
        }
    }

    public static <T> Iterable<T> getExtent(Class<T> type) throws ClassNotFoundException {
        if(allExtents.containsKey(type)) {
            return (Iterable<T>) allExtents.get(type);
        }

        throw new ClassNotFoundException(String.format("%s. Stored extents: %s", type.toString(), allExtents.keySet()));
    }
    public static <T> void deleteExtension(T name) {
        List<T> list = (List<T>) allExtents.get(name.getClass());
        list.remove(name);
    }

    public static List<Rower> getRowerExtent(Class theClass) throws Exception {
        List extent = null;
        if(allExtents.containsKey(theClass)) {
            // Extent of this class already exist
            extent = allExtents.get(theClass);
        }
        else {
            throw new Exception("Unknown class " + theClass);
        }
        return extent;
    }
    public static List<Rower> getAllRowerExtent() throws Exception {
        List extent= new ArrayList();
        if(allExtents.containsKey(BMX.class)) {
            // Extent of this class already exist
            extent.addAll(allExtents.get(BMX.class));
        }
        if(allExtents.containsKey(MTB.class)) {
            // Extent of this class already exist
            extent.addAll( allExtents.get(MTB.class));
        }
        if(allExtents.containsKey(Szosowy.class)) {
            // Extent of this class already exist
            extent.addAll(allExtents.get(Szosowy.class));
        }
        return extent;
    }
    public static List<Zamowienie> getZamowienieExtent() throws Exception {
        List extent = null;
        if(allExtents.containsKey(Zamowienie.class)) {
            // Extent of this class already exist
            extent = allExtents.get(Zamowienie.class);
        }

        return extent;
    }
    public static List<Platnosc> getPlatnoscExtent() throws Exception {
        List extent = new ArrayList();
        if(allExtents.containsKey(Platnosc.class)) {
            // Extent of this class already exist
            extent = allExtents.get(Platnosc.class);
        }
        else {
            throw new Exception("Unknown class " + Platnosc.class);
        }
        return extent;
    }
}
