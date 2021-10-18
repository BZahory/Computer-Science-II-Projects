package p5_zahory_b;

public class DecisionPoint implements Comparable<DecisionPoint>{
        private String key;
        private Question question;

        public DecisionPoint(String key, Question question)
        {
            this.key = key;
            this.question = question;
        }

        public String getKey(){return key;}
        public Question getQues(){return question;}

        public int compareTo(DecisionPoint y)
        {
            return compareHelper(this.toString(), y.toString());
        }

        public int compareHelper(String x, String y){
            if((int)x.charAt(0)<(int)y.charAt(0))
                return -1;
            else if ((int)x.charAt(0)<(int)y.charAt(0))
                return 1;
            else
            if(x.length()>1&&y.length()>1)
                return compareHelper(x.substring(1),y.substring(1));
            else if(x.length()==1)
                return -1;
            else
                return 1;
        }

        public String toString()
        {
            return key;
        }

}

