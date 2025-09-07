package basics.o15.enumy.metodyabstr;

public enum CarEnum {

    ACCELERATE_QUICKLY {
        @Override
        public String accelerate() {
            return "accelerates quickly";
        }
    },
    ACCELERATE_SLOWLY {
        @Override
        public String accelerate() {
            return "accelerates slowly";
        }
    };

    public abstract String accelerate();
}
