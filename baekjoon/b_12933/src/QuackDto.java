import java.util.ArrayList;
import java.util.List;

public class QuackDto {
    private int Index = -1;
    private String status = "NoCounting";
    List<Boolean> Quack = new ArrayList<>();

    public QuackDto() { //새로 카운팅 하는 경우
        Quack.add(true); //q는 true
        Index++;

        //나머지 문자열은 false로 세팅
        Quack.add(false);
        Quack.add(false);
        Quack.add(false);
        Quack.add(false);
    }

    public boolean AddQuack(int index){
        if(Quack.get(index-1).equals(true)){
            if(Quack.get(index).equals(false)){ //인수가 해당 dto에서 처음 받는 문자열인지 검증
                Quack.set(index,true);
                Index++;
                return true;
            }
        }
        return false;
    }

    public String IsMax() {
        if(Index==4){
            refreshQuack(); //해당 dto 재활용 위해 해당 dto 초기화
            if(status.equals("NoCounting")) {
                status = "Counting";
                return "Max";
            }
        }
        return "NotMax";
    }

    private void refreshQuack(){
        Index=0;
        for(int i=1; i<5; i++){ //이미 한 번 울었던 오리임을 체크하기 위해, q자리는 true에서 바꾸지 않음
            Quack.set(i,false);
        }
    }

}
