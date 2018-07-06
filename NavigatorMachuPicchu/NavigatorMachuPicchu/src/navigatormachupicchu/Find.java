
package navigatormachupicchu;

public class Find implements Navigator{

    @Override
    public char[][] searchRoute(char[][] map) {
        int rows = map.length;
        int columns = map[0].length;
        int endRoutei=0;
        int endRoutej=0;
        
        int [][] mapNew=new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                switch (map[i][j]) {
                    case '#':
                        mapNew[i][j]=-1;
                        break;
                    case '@':
                        mapNew[i][j]=1;
                        break;
                    case 'x':
                        endRoutei=i;
                        endRoutej=j;     
                        break;
                    default:
                        break;
                }
            }
        }
        int d=1;
        while (mapNew[endRoutei][endRoutej]!=d){
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (mapNew[i][j]==d){
                       if (i>0&&(mapNew[i-1][j]!=-1)&&(mapNew[i-1][j]<1)) mapNew[i-1][j]=d+1;
                       if (i<rows-1&&mapNew[i+1][j]!=-1&&(mapNew[i+1][j]<1)) mapNew[i+1][j]=d+1;
                       if (j<(columns)-1&&mapNew[i][j+1]!=-1&&(mapNew[i][j+1]<1)) mapNew[i][j+1]=d+1;
                       if (j>0&&mapNew[i][j-1]!=-1&&(mapNew[i][j-1]<1)) mapNew[i][j-1]=d+1;

                   }
                }
            }
        d=d+1;
            if (d>rows*columns) {
                d=-1;
                break;
            }
        }
        if (d!=-1) {
         
            while  (d!=2){
                if (endRoutei>0&&mapNew [endRoutei-1][endRoutej]==d-1) {
                   map [endRoutei-1][endRoutej]='+';
                   endRoutei=endRoutei-1;
                }else if (endRoutei<rows-1&&mapNew [endRoutei+1][endRoutej]==d-1) {
                   map [endRoutei+1][endRoutej]='+';
                   endRoutei=endRoutei+1;
                }else if (endRoutej<(columns)-1&&mapNew [endRoutei][endRoutej+1]==d-1) {
                   map [endRoutei][endRoutej+1]='+';
                   endRoutej=endRoutej+1;
                }else if (endRoutej>0&&mapNew [endRoutei][endRoutej-1]==d-1) {
                   map [endRoutei][endRoutej-1]='+';
                   endRoutej=endRoutej-1;
                }
            d=d-1;
            }
        return map;
        }else return null;
    
    }
    
}
