import utils.SOPrintUtil;

/**
 * 回溯法，可以看成是蛮力法的升级版，它从解决问题每一步的所有选项里系统的萱蕚出一个可行的解决方案
 *
 *
 *
 * 设计一个函数，来判断矩阵中是否存在一条包含某字符串所有字符的路径，每一步可以是矩阵上下左右移动一格，如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子
 * 这次判断 "bfce"
 *
 * 这里行列写反了
 *
 */
public class _12_backtracking {

    public static void main(String[] args){

        char[][] datas = new char[][]{
                {'a','b','t','g'},
                {'c','f','c','s'},
                {'j','d','e','h'}};

        String findStr = "bfce";

//        String findStr = "abfb";

        SOPrintUtil.println(havePath(datas, findStr));
    }



    public static boolean havePath(char[][] datas,String findStr){
        if (datas==null|| datas.length==0||datas[0].length==0 || findStr == null){
            return false;
        }

        boolean[][] visited = new boolean[datas.length][datas[0].length];


        int pathLength = 0;
        for (int col=0;col<datas[0].length;col++){
            for (int row = 0;row<datas.length;row++){
               if( havePathCore(datas, row, col, findStr.toCharArray(),pathLength,visited)){
                   SOPrintUtil.println();
                   return true;
               }
            }
        }

        return false;

    }



    public static boolean havePathCore(char[][] datas,int row,int col,char[] findStr,int pathLength,boolean[][] visited){
        if (findStr.length==pathLength){
            return true;
        }
        boolean hasPath = false;
        if(row>=0 && row<datas[0].length && col>=0 && col<datas.length && datas[col][row]==findStr[pathLength] && !visited[col][row]){
            ++pathLength;
            visited[col][row] = true;
            hasPath = havePathCore(datas, row+1, col, findStr, pathLength, visited)||
                    havePathCore(datas, row-1, col, findStr, pathLength, visited)||
                    havePathCore(datas, row, col+1, findStr, pathLength, visited)||
                    havePathCore(datas, row, col-1, findStr, pathLength, visited);

            if(!hasPath){
                --pathLength;
                visited[col][row] = false;
            }
        }

        if(hasPath)
            SOPrintUtil.println(row,col);
        return hasPath;
    }

}
