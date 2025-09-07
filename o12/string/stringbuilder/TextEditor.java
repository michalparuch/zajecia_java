package basics.o12.string.stringbuilder;

public class TextEditor {

    private final StringBuilder sb;

    public TextEditor() {
        sb = new StringBuilder();
    }

    public void addText(String text){
        sb.append(text);
    }

    public void insert(int index, String text) {
        if (index >= 0 && index <= text.length()) {
            sb.insert(index, text);
        } else {
            throw new IndexOutOfBoundsException("Wrong Index");
        }
    }

    public void delete(int start, int end) {
        if (start >= 0 && end <= sb.length() && start < end) {
            sb.delete(start, end);
        } else {
            throw new IndexOutOfBoundsException("Wrong Index");
        }
    }

    public void reverse(){
        sb.reverse();
    }

    public void printText(){
        System.out.println(sb.toString());
    }

}
