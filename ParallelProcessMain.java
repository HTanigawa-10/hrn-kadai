package practice009;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParallelProcessMain {
    public static void main (String args[]){
        // 処理対象のリスト
        List<String> list = new ArrayList<>();
        // とりあえず5個あるものとする
        for(int i = 0; i < 5; i++){
            list.add("処理対象" + (i +1));
        }

        // 処理開始の時間(ミリ秒)取得
        long startTime = System.currentTimeMillis();

        // 処理結果受け取り用のリストを作成
        //List<String> resultList = new ArrayList<>();
        List<Future<String>> resultList = new ArrayList<>();
       　
        //固定数のスレッドを再利用するスレッド・プールを作成
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // 処理対象を順番にサブ処理１～３に渡して処理実行
        for(String proc : list){
//            resultList.add(new ParallelProcessSub1(proc).process());
//            resultList.add(new ParallelProcessSub2(proc).process());
//            resultList.add(new ParallelProcessSub3(proc).process());
            resultList.add(executor.submit(new ParallelProcessSub1(proc)));
            resultList.add(executor.submit(new ParallelProcessSub2(proc)));
            resultList.add(executor.submit(new ParallelProcessSub3(proc)));
            System.out.println(proc + "実行済み");
        }

        // 実行結果を取得する
        //for(String result : resultList){
        for(Future<String> result : resultList){
            try{
                //System.out.println(result);
            	System.out.println(result.get());
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        // 処理終了の時間(ミリ秒)取得
        long endTime = System.currentTimeMillis();

        // 実行時間を算出(ミリ秒)
        System.out.println("実行時間： " + (endTime -startTime));
    }

}
