package string.container;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringContainer {
    private StringContainer nextElement;
    private String text;
    private String pattern;
    private int size = 0;

    public StringContainer(String pattern) {
        this.pattern = pattern;
    }

    public StringContainer findLast() {
        StringContainer last = this;
        while (last.nextElement != null) {
            last = last.nextElement;
        }
        return last;
    }

    public void add(String str) {
        if (str.matches(pattern)) {
            StringContainer last = this.findLast();
            last.nextElement = new StringContainer(pattern);
            last.nextElement.text = str;
            size++;
        } else {
            throw new IllegalArgumentException("Incorrect format.");
        }
    }

    public StringContainer get(int index) {
        if (size <= index) {
            throw new IllegalArgumentException("There is not so many elements.");
        }
        StringContainer selected = this;
        int i = 0;
        while (index >= i) {
            selected = selected.nextElement;
            i++;
        }
        return selected;
    }

    public void removeNext() {
        nextElement = nextElement.nextElement;
    }

    public void remove(int index) {
        get(index - 1).removeNext();
        size--;
    }

    public void remove(String remove) {
        StringContainer before = this;
        while (!before.nextElement.text.equals(remove)) {
            before = before.nextElement;
        }
        before.removeNext();
        size--;
    }

    //        Set<String> uniqueValues = st.getUniqueValues(); // pobiera wszystkie rozne wartosci bez powtorzen.

    public Set<String> getUniqueValues(){
        Set<String> uv = new HashSet<>();
        for(int i=0; i<size(); i++){
            uv.add(get(i).text);
        }
        return uv;
    }

    //        String postPopular = st.getMostPopularValue(); // powinno pobrac wartosc ktora sie najwiecej razy powtarza

    public int amount(String str){
        int nb=0;
        for (int i = 0; i < size(); i++) {
            if(get(i).text.equals(str)){
                nb++;
            }
        }
        return nb;
    }

    public String getMostPopularValue(){
        if(size==0){
            throw new IllegalArgumentException("There are no elements.");
        }
        List<String> uniqueList = new ArrayList<>(getUniqueValues());
        String mostPopular = uniqueList.get(0);
        for(int i=0; i<uniqueList.size(); i++){
            if(amount(uniqueList.get(i))>amount(mostPopular)){
                mostPopular=uniqueList.get(i);
            }
        }
        return mostPopular;
    }

//        public int size(){ // Gdyby miało być pez parametru size
//        int size = 0;
//        StringContainer element = this;
//        while(element.nextElement!=null) {
//            element=element.nextElement;
//            size++;
//        }
//        return size;
//    }

    public int size() {
        return size;
    }

    public String getText() {
        return text;
    }

    public StringContainer getNextElement() {
        return nextElement;
    }

    public String getPattern() {
        return pattern;
    }

    @Override
    public String toString() {
        if(text==null){
            return pattern;
        }
        return text;
    }
}
