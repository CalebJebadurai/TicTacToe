import java.io.*;
import java.util.*;
class TicTacToe
{
    String TTT[][]=new String[4][4],winner="";
    static int m,n,i,j,R,C,f,F;
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static TicTacToe Tic=new TicTacToe();
    public static void TicTacToe()throws IOException
    {
        Tic.display();        Tic.input();        Tic.computer1();        Tic.display();
        //         mainLoop:
        do
        {
            //             Tic.CheckWinner();
            //             if(F==5)
            //                 break;
            //             Tic.display();
            Tic.CheckWinner();
            if(F==5)
                break;            
            Tic.input();
            Tic.CheckWinner();
            if(F==5)
                break;
            Tic.computer2();
            Tic.CheckWinner();
            if(F==5)
                break;
            Tic.display();
            Tic.CheckWinner();
        }
        while(F==10);
    }

    void CheckWinner()
    {
        for(i=1;i<=3;i++)
        {
            if((TTT[i][1]=="O"&&TTT[i][2]=="O"&&TTT[i][3]=="O")||(TTT[1][i]=="O"&&TTT[2][i]=="O"&&TTT[3][i]=="O")||(TTT[1][1]=="O"&&TTT[2][2]=="O"&&TTT[3][3]=="O")||(TTT[3][1]=="O"&&TTT[1][3]=="O"&&TTT[2][2]=="O"))
            {
                F=5;
                winner="O";
            }
            else
            if((TTT[i][1]=="X"&&TTT[i][2]=="X"&&TTT[i][3]=="X")||(TTT[1][i]=="X"&&TTT[2][i]=="X"&&TTT[3][i]=="X")||(TTT[1][1]=="X"&&TTT[2][2]=="X"&&TTT[3][3]=="X")||(TTT[3][1]=="X"&&TTT[1][3]=="X"&&TTT[2][2]=="X"))
            {
                F=5;
                winner="X";
            }
            else F=10;
        }
        if(TTT[1][1]!=null&&TTT[1][2]!=null&&TTT[1][3]!=null&&TTT[2][1]!=null&&TTT[2][2]!=null&&TTT[2][3]!=null&&TTT[3][1]!=null&&TTT[3][2]!=null&&TTT[3][3]!=null&&winner!="O"&&winner!="X")
        {
            F=5;
            winner="DRAW";
        }
        Tic.winner(winner);
    }

    void display()
    {
        System.out.println("\f\n\n\n\n");
        System.out.println("\t\t\t\t------------------------------");//-452
        System.out.println("\t\t\t\tR/C?\t1\t¦¦\t2\t¦¦\t3\t¦¦");                //¦435?25?26
        System.out.println("\t\t\t\t?   \t \t¦¦\t \t¦¦\t \t¦¦");
        for(i=1;i<=3;i++)
        {
            System.out.print("\t\t\t\t"+(i)+"  \t");
            for(j=1;j<=3;j++)
            {
                if(TTT[i][j]==null)
                    System.out.print("¦");
                else
                    System.out.print(TTT[i][j]);
                if(j!=3)
                    System.out.print("\t¦¦\t");
                if(j==3)
                    System.out.print("\t¦¦");
            }
            System.out.println();
        }
        System.out.println("\t\t\t\t------------------------------");//-452
    }

    void input()throws IOException
    {

        do
        {
            f=0;
            try
            {
                System.out.print("\n\n\t\t\t\t    Enter The Row Number:- ");
                R=Integer.parseInt(br.readLine());
                System.out.print("\t\t\t\tEnter The Coloumn Number:- ");
                C=Integer.parseInt(br.readLine());

                if(TTT[R][C]==null)
                    TTT[R][C]="X";
                else
                {
                    System.out.println("\t\t\t\tThe Space is OCCUPAID by ? "+TTT[R][C]);
                    System.out.println("\t\t\t\tTry ANOTHER Space!!!");
                    f=1;
                }
            }
            catch(Exception e)
            {
                System.out.print("\t\t\t\tEnter Numbers less Than 3!!!\n\n\t\t\t\t"+e);
                f=1;
            }
        }
        while(f==1);
    }

    void computer1()
    {
        if(TTT[1][1]=="X"||TTT[1][2]=="X"||TTT[1][3]=="X"||TTT[2][1]=="X"||TTT[2][3]=="X"||TTT[3][1]=="X"||TTT[3][2]=="X"||TTT[3][3]=="X")
        {
            TTT[2][2]="O";
        }
        if(TTT[2][2]=="X")
            TTT[3][3]="O";
    }

    void computer2()
    {
        outer:
        do
        {
            /**
             * FOR "O's" TURN TOWARDS WINNING---->???
             */

            //coloumn
            for(i=1;i<=3;i++)
            {
                if(TTT[i][1]=="O"&&TTT[i][2]=="O")
                {
                    if(TTT[i][3]==null)
                    {
                        TTT[i][3]="O";

                        break outer;
                    }
                }
                else if(TTT[i][1]=="O"&&TTT[i][3]=="O")
                {
                    if(TTT[i][2]==null)
                    {
                        TTT[i][2]="O";

                        break outer;
                    }
                }
                else if(TTT[i][2]=="O"&&TTT[i][3]=="O")
                {
                    if(TTT[i][1]==null)
                    {
                        TTT[i][1]="O";

                        break outer;
                    }
                }
            }

            //rows
            for(i=1;i<=3;i++)
            {
                if(TTT[1][i]=="O"&&TTT[2][i]=="O")
                {
                    if(TTT[3][i]==null)
                    {
                        TTT[3][i]="O";

                        break outer;
                    }
                }
                else if(TTT[1][i]=="O"&&TTT[3][i]=="O")
                {
                    if(TTT[2][i]==null)
                    {
                        TTT[2][i]="O";

                        break outer;
                    }
                }
                else if(TTT[2][i]=="O"&&TTT[3][i]=="O")
                {
                    if(TTT[1][i]==null)
                    {
                        TTT[1][i]="O";

                        break outer;
                    }
                }
            }

            //diagonalsRight
            for(i=1;i<=3;i++)
            {
                if(TTT[1][1]=="O"&&TTT[2][2]=="O")
                {
                    if(TTT[3][3]==null)
                    {
                        TTT[3][3]="O";

                        break outer;
                    }
                }
                else if(TTT[1][1]=="O"&&TTT[3][3]=="O")
                {
                    if(TTT[2][2]==null)
                    {
                        TTT[2][2]="O";

                        break outer;
                    }
                }
                else if(TTT[2][2]=="O"&&TTT[3][3]=="O")
                {
                    if(TTT[1][1]==null)
                    { 
                        TTT[1][1]="O";

                        break outer;
                    }
                }
            }

            // diagonalLeft
            for(i=1;i<=3;i++)
            {
                if(TTT[3][1]=="O"&&TTT[1][3]=="O")
                {
                    if(TTT[2][2]==null)
                    { 
                        TTT[2][2]="O";

                        break outer;
                    }
                }
                else if(TTT[3][1]=="O"&&TTT[2][2]=="O")
                {
                    if(TTT[1][3]==null)
                    { 
                        TTT[1][3]="O";

                        break outer;
                    }
                }
                else if(TTT[1][3]=="O"&&TTT[2][2]=="O")
                {
                    if(TTT[3][1]==null)
                    {    
                        TTT[3][1]="O";

                        break outer;
                    }
                }
            }

            /** "O"'s Defence against "X"---->??? ??? ???
             * 
             */
            //Rows
            for(i=1;i<=3;i++)
            {
                if(TTT[i][1]=="X"&&TTT[i][2]=="X")
                {
                    if(TTT[i][3]==null)
                    {    
                        TTT[i][3]="O";

                        break outer;
                    }
                }
                else if(TTT[i][1]=="X"&&TTT[i][3]=="X")
                {
                    if(TTT[i][2]==null)
                    {
                        TTT[i][2]="O";

                        break outer;
                    }
                }
                else if(TTT[i][2]=="X"&&TTT[i][3]=="X")
                {
                    if(TTT[i][1]==null)
                    {
                        TTT[i][1]="O";

                        break outer;
                    }
                }
            }

            //Coloumns
            for(i=1;i<=3;i++)
            {
                if(TTT[1][i]=="X"&&TTT[2][i]=="X")
                {
                    if(TTT[3][i]==null)
                    {
                        TTT[3][i]="O";

                        break outer;
                    }
                }
                else if(TTT[1][i]=="X"&&TTT[3][i]=="X")
                {
                    if(TTT[2][i]==null)
                    {   
                        TTT[2][i]="O";

                        break outer;
                    }
                }
                else if(TTT[2][i]=="X"&&TTT[3][i]=="X")
                {
                    if(TTT[1][i]==null)
                    {   
                        TTT[1][i]="O";

                        break outer;
                    }
                }
            }

            //diagonalsRight
            for(i=1;i<=3;i++)
            {
                if(TTT[1][1]=="X"&&TTT[2][2]=="X")
                {
                    if(TTT[3][3]==null)
                    {  
                        TTT[3][3]="O";

                        break outer;
                    }
                }
                else if(TTT[1][1]=="X"&&TTT[3][3]=="X")
                {
                    if(TTT[2][2]==null)
                    {   
                        TTT[2][2]="O";

                        break outer;
                    }
                }
                else if(TTT[2][2]=="X"&&TTT[3][3]=="X")
                {
                    if(TTT[1][1]==null)
                    {   
                        TTT[1][1]="O";

                        break outer;
                    }
                }
            }

            //diagonalLeft
            for(i=1;i<=3;i++)
            {
                if(TTT[3][1]=="X"&&TTT[1][3]=="X")
                {
                    if(TTT[2][2]==null)
                    {   
                        TTT[2][2]="O";

                        break outer;
                    }
                }
                else if(TTT[3][1]=="X"&&TTT[2][2]=="X")
                {
                    if(TTT[1][3]==null)
                    {   
                        TTT[1][3]="O";

                        break outer;
                    }
                }
                else if(TTT[1][3]=="X"&&TTT[2][2]=="X")
                {
                    if(TTT[3][1]==null)
                    {  
                        TTT[3][1]="O";

                        break outer;
                    }
                }
            }

            /**
             * Strategy of "O" 
             */
            for(i=1;i<=3;i++)
            {

                if(TTT[2][2]=="O"&&TTT[2][1]==null&&TTT[2][3]==null)
                {
                    TTT[2][1]="O";
                    break outer;
                }
                else if(TTT[2][2]=="O"&&TTT[1][2]==null&&TTT[3][2]==null)
                {
                    TTT[1][2]="O";
                    break outer;
                }
                else if(TTT[2][2]=="O"&&TTT[1][1]==null&&TTT[3][3]==null)
                {
                    if(TTT[3][2]==null||TTT[2][3]==null)
                    TTT[3][3]="O";
                    else TTT[1][1]="O";
                    break outer;
                }
                else if(TTT[2][2]=="O"&&TTT[3][1]==null&&TTT[1][3]==null)
                {
                    if(TTT[1][2]==null||TTT[2][3]==null)
                    TTT[1][3]="O";
                    else TTT[3][1]="O";
                    break outer;
                }

                else if(TTT[2][2]=="X"&&TTT[3][3]=="O"&&TTT[1][1]=="X")
                {
                    TTT[3][1]="O";
                    break outer;
                }
            }
            f=0;
        }
        while(f==1);

    }

    void winner(String winner)
    {
        Tic.display();
        if(winner=="X")
        {
            System.out.println("\t\t\t\t'X' IS THE WINNER!!!????");
            System.out.println("  *¦¦******¦¦*****¦¦¦*****¦¦****¦¦******¦¦**********¦¦*¦¦¦¦¦¦*¦¦¦¦****¦¦¦***¦¦***¦¦***¦¦****");
            System.out.println("  **¦¦****¦¦****¦¦**¦¦***¦¦****¦¦*****¦¦************¦¦*****¦¦*****¦¦¦*****¦¦****¦¦¦*¦¦¦*¦¦¦***");
            System.out.println("  ***¦¦**¦¦****¦¦****¦¦**¦¦****¦¦*****¦¦************¦¦*****¦¦*****¦¦¦¦***¦¦****¦¦¦*¦¦¦*¦¦¦***");
            System.out.println("  ****¦¦¦¦*****¦¦****¦¦**¦¦****¦¦*****¦¦************¦¦*****¦¦*****¦¦*¦¦**¦¦****¦¦¦*¦¦¦*¦¦¦***");
            System.out.println("  ******¦¦******¦¦****¦¦**¦¦****¦¦******¦¦***¦¦*****¦¦*****¦¦*****¦¦**¦¦*¦¦*****¦¦**¦¦***¦¦****");
            System.out.println("  ******¦¦******¦¦****¦¦**¦¦****¦¦******¦¦*¦¦*¦¦**¦¦*****¦¦*****¦¦***¦¦*¦¦*****¦¦**¦¦***¦¦****");
            System.out.println("  ******¦¦*******¦¦**¦¦****¦¦**¦¦********¦¦¦¦**¦¦¦¦*****¦¦*****¦¦****¦¦¦¦******¦****¦****¦******");
            System.out.println("  ******¦¦*********¦¦¦********¦¦¦************¦¦****¦¦****¦¦¦¦¦¦*¦¦¦****¦¦¦¦****¦¦**¦¦**¦¦*****");
            System.exit(0);
        }

        if(winner=="O")
        {
            System.out.println("\t\t\t\t'O' IS THE WINNER!!!????");
            System.out.println("*¦¦******¦¦*****¦¦¦*****¦¦****¦¦******¦¦**********¦¦¦*********¦¦¦*******¦¦¦¦*****¦¦¦¦¦¦****¦¦***¦¦***¦¦***");
            System.out.println("**¦¦****¦¦****¦¦**¦¦***¦¦****¦¦******¦¦********¦¦**¦¦*****¦¦**¦¦****¦¦***¦¦****¦¦**********¦¦¦*¦¦¦*¦¦¦***");
            System.out.println("***¦¦**¦¦****¦¦****¦¦**¦¦****¦¦******¦¦*******¦¦****¦¦***¦¦****¦¦**¦¦***********¦¦**********¦¦¦*¦¦¦*¦¦¦***");
            System.out.println("****¦¦¦¦*****¦¦****¦¦**¦¦****¦¦******¦¦*******¦¦****¦¦***¦¦****¦¦***¦¦**********¦¦**********¦¦¦*¦¦¦*¦¦¦***");
            System.out.println("******¦¦******¦¦****¦¦**¦¦****¦¦******¦¦*******¦¦****¦¦***¦¦****¦¦*******¦¦******¦¦¦¦********¦¦**¦¦***¦¦****");
            System.out.println("******¦¦******¦¦****¦¦**¦¦****¦¦******¦¦*******¦¦****¦¦***¦¦****¦¦**********¦¦***¦¦************¦¦**¦¦***¦¦***");
            System.out.println("******¦¦*******¦¦**¦¦****¦¦**¦¦*******¦¦********¦¦**¦¦*****¦¦**¦¦***¦¦****¦¦***¦¦*************¦****¦****¦*****");
            System.out.println("******¦¦*********¦¦¦********¦¦¦********¦¦¦¦¦*****¦¦***********¦¦********¦¦¦¦*****¦¦¦¦¦¦******¦¦**¦¦**¦¦****");
            System.exit(0);
        }

        if(winner=="DRAW")
        {
            System.out.println("\t\t\t\tIT'S A DRAW!!!????");
            System.out.println("\t\t****¦¦¦¦*******¦¦¦¦¦¦**********¦¦¦*****¦¦***********¦¦*****¦¦***¦¦***¦¦***");
            System.out.println("\t\t******¦¦*¦¦*****¦¦*****¦¦*****¦¦*¦¦****¦¦************¦¦****¦¦¦*¦¦¦*¦¦¦***");
            System.out.println("\t\t******¦¦***¦¦***¦¦******¦¦***¦¦***¦¦***¦¦************¦¦****¦¦¦*¦¦¦*¦¦¦***");
            System.out.println("\t\t******¦¦****¦¦**¦¦*****¦¦****¦¦***¦¦***¦¦************¦¦****¦¦¦*¦¦¦*¦¦¦***");
            System.out.println("\t\t******¦¦****¦¦**¦¦¦¦¦¦*****¦¦¦¦¦¦***¦¦****¦¦****¦¦*****¦¦**¦¦***¦¦*****");
            System.out.println("\t\t******¦¦****¦¦**¦¦****¦¦****¦¦*****¦¦**¦¦*¦¦*¦¦**¦¦******¦¦**¦¦***¦¦****");
            System.out.println("\t\t******¦¦**¦¦****¦¦*****¦¦***¦¦*****¦¦***¦¦¦¦**¦¦¦¦********¦****¦****¦*****");
            System.out.println("\t\t*****¦¦¦¦******¦¦¦*****¦¦**¦¦*****¦¦****¦¦******¦¦**********¦¦**¦¦**¦¦****");
            System.exit(0);
        }
    }
}