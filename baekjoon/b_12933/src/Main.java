import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<QuackDto> QuackRepository = new ArrayList<>();
    static int QuackNum = 0;
    static boolean WrongInput = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputString =  scanner.nextLine();
        String [] InputArray = inputString.split("");

        for(String input : InputArray){
            if(input.equals("q")){
                if(QuackNum==0){ //현재까지 다 운 오리가 없을때만 새로운 오리 객체 생성
                    QuackRepository.add(new QuackDto());
                }
                continue;
            }
            try{
                CheckRepository(input);
            }
            catch (IllegalArgumentException e){
                WrongInput = true;
                break;
            }
        }
        if(QuackNum==0 || WrongInput){
            QuackNum=-1;
        }
        System.out.println(QuackNum);
    }

    private static void CheckRepository(String inputString) {

        boolean IsValidate = false;
        for(QuackDto quackDto : QuackRepository){
            int index = ToIndex(inputString);
            boolean IsAdd = quackDto.AddQuack(index);
            if(IsAdd) { //해당 dto에서 값을 넣었을때, quack 문자열 완성 시
                if(quackDto.IsMax().equals("Max")){
                    QuackNum++;
                }
                IsValidate = true;
                break;
            }
        }
        if(!IsValidate){
            throw new IllegalArgumentException(); //inputString이 어느 객체에도 들어가지 않는다면, 잘못된 입력임
        }
    }

    private static int ToIndex(String input){
        if(input.equals("u")){
            return 1;
        }
        else if(input.equals("a")){
            return 2;
        }
        else if(input.equals("c")){
            return 3;
        }
        else {
            return 4;
        }
    }

}