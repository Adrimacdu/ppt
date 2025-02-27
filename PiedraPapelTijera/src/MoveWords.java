import java.util.Random;

public class MoveWords{

    public static final int EMPATE = 0;
    public static final int GANA = 1;
    public static final int PIERDE = 2;

    private static final String[] validMoves = {"TIJERAS", "PAPEL", "PIEDRA","SPOCK","LAGARTO"};
    private static final String[] validCommands = {"SALIR", "HELP"};

    private Random rnd;
    
    public MoveWords(){
    	rnd = new Random();
    }
    
    public boolean isValidMoveCommand(String value){

	    for (int i =0; i< validMoves.length; i++){
	        if(validMoves[i].equals(value))
	    	    return true;
	    }
	    
	    for (int i =0; i< validCommands.length; i++){
	        if(validCommands[i].equals(value))
		        return true;
	    }
	    
	    return false;
    }

    public String randomMove(){
	    float p = rnd.nextFloat();
	    return validMoves[ (int) (p * validMoves.length)];
    }

    public void showMoves(){
        for (String move : validMoves)
	        System.out.print(move+" ");
	    System.out.println();
    }
    public void showCommands(){
	    for (String cmd : validCommands)
	        System.out.print(cmd+" ");
	    System.out.println();
    }

    public void showWords(){
        showMoves();
        showCommands();    
    }

    private static int getIndex(String value){
	    for (int i =0; i< validMoves.length; i++){
	        if(validMoves[i].equals(value))
		        return i;
	    }
    	return -1;
    }

   public static int checkWinner(String first, String second){
        int first_i, second_i;

        first_i = getIndex(first);
        second_i = getIndex(second);

        if (first_i == second_i) return EMPATE;

        switch (first_i){
            case 0:
                if (second_i == 1){
                    return GANA;
                } else if (second_i == 2){
                    return PIERDE;
                } else if (second_i == 3){
                    return PIERDE;
                } else if (second_i == 4){
                    return GANA;
                }
            case 1:
                if (second_i == 0){
                    return PIERDE;
                } else if (second_i == 2){
                    return GANA;
                } else if (second_i == 3){
                    return GANA;
                } else if (second_i == 4){
                    return PIERDE;
                }
            case 2:
                if (second_i == 0){
                    return GANA;
                } else if (second_i == 1){
                    return PIERDE;
                } else if (second_i == 3){
                    return PIERDE;
                } else if (second_i == 4){
                    return GANA;
                }
            case 3:
                if (second_i == 0){
                    return PIERDE;
                } else if (second_i == 1){
                    return GANA;
                } else if (second_i == 2){
                    return GANA;
                } else if (second_i == 4){
                    return PIERDE;
                }
            case 4:
                if (second_i == 0){
                    return PIERDE;
                } else if (second_i == 1){
                    return GANA;
                } else if (second_i == 2){
                    return PIERDE;
                } else if (second_i == 3){
                    return GANA;
                }
        }
        return -1;
    }
	
} 
