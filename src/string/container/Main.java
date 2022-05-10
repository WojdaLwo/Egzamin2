package string.container;

//Zadanie01: napisz kod tak aby fragment ponizej dzialal i sie kompilowal. - ale nie mozesz uzywac tablic, list, setow, zadnych kolekcji czy kolejek, ani konkatenowac to w Stringi czy appendowac
//        w string buildery
//
////tworzymy klaske String container ktora bedzie mogla przyjmowac tylko Stringi z okreslonym Patternem podanym jako argument.
////tu w przykladzie dodajemy kody pocztowe
//        StringContainer st = new StringContainer("\\d{2}[-]\\d{3}");
//
//        st.add("02-495");//git
//        st.add("01-120");//git
//        st.add("05-123");//git
//        st.add("00-000");//git
////st.add("ala ma kota"); //nie powinno dodac bo wartosc nie pasuje do wzoru
//        for(int i=0; i<st.size(); i++){
//        System.out.println(st.get(i)); //powinno wypisac dodane kody pocztowe
//        }
//
//        st.remove(0);  //usuwa "02-495"
//        st.remove("00-000"); // usuwa "00-000"
//
//        System.out.println("po usunieciu");
//        for(int i=0; i<st.size(); i++){
//        System.out.println(st.get(i)); //powinno wypisac dodane kody pocztowe
//        }
//
////do zrobienia ponizszych metod mozesz juz uzyc map i kolekcji.
//        dodatkowo mozesz zrobic:
//        String postPopular = st.getMostPopularValue(); // powinno pobrac wartosc ktora sie najwiecej razy powtarza
//        Set<String> uniqueValues = st.getUniqueValues(); // pobiera wszystkie rozne wartosci bez powtorzen.

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        StringContainer st = new StringContainer("\\d{2}[-]\\d{3}");
        st.add("02-495");//git
        st.add("01-120");//git
        st.add("05-123");//git
        st.add("00-000");//git
//st.add("ala ma kota"); //nie powinno dodac bo wartosc nie pasuje do wzoru
        for(int i=0; i<st.size(); i++){
            System.out.println(st.get(i)); //powinno wypisac dodane kody pocztowe
        }

        st.remove(0);  //usuwa "02-495"
        st.remove("00-000"); // usuwa "00-000"


        System.out.println("po usunieciu");
        for(int i=0; i<st.size(); i++){
            System.out.println(st.get(i)); //powinno wypisac dodane kody pocztowe
        }

        st.add("01-120");//git
        st.add("05-123");//git
        st.add("05-123");//git
        st.add("00-000");//git

        String mostPopular = st.getMostPopularValue(); // powinno pobrac wartosc ktora sie najwiecej razy powtarza
        Set<String> uniqueValues = st.getUniqueValues(); // pobiera wszystkie rozne wartosci bez powtorzen.
        System.out.println("Most popular is: "+mostPopular);
        System.out.println(uniqueValues);
    }
}
