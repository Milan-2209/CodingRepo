package src.com.codes.practice.general;

public class GoodCells {

    public static int goodCells(int[][] v){
        int count = 0;
        for(int i=0;i<v.length;i++){
            for(int j=0;j<v[i].length;j++){
                int rowResult = -1;
                int colResult = -1;
                int l;
                int k;
                for(l=j+1;l<v[i].length;i++){
                    if(rowResult!=-1){
                        if(rowResult==XOR(v[i][j],v[i][l]))
                            continue;
                        else
                            break;
                    }
                    else
                        rowResult = XOR(v[i][j],v[i][l]);

                }
                System.out.println(l);
                for(k=i+1;k<v.length;k++){
                    if(colResult!=-1){
                        if(colResult==XOR(v[i][j],v[k][j]))
                            continue;
                        else
                            break;
                    }
                    else
                        colResult = XOR(v[i][j],v[k][j]);

                }
                System.out.println(k);
                if(l==v[i].length-1 && k== v.length-1)
                    count+=1;

            }
        }
        return count;
    }

    private static int XOR(int i,int j){
        if(i==j)
            return 0;
        else
            return 1;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0,0},
                {1,0}
        };
        System.out.println(goodCells(matrix));
    }
}
