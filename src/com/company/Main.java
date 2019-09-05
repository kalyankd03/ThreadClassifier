package com.company;
import com.company.model.FileRange;
import com.company.model.FileVal;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        String st;
        List<FileVal> fileList = new ArrayList<FileVal>();
        int i=0;
        //reading no of files and no of threads required
        String temp = br.readLine();
        String arr[] =temp.split(" ");
        int noOfFlies = Integer.parseInt(arr[0]);
        int N =  Integer.parseInt(arr[1]);
        while(noOfFlies-->0){

            FileVal newFile = parseInput(br.readLine());
            fileList.add(newFile);
        }



        List<List<FileRange>> result = getSplits(fileList,N);
        System.out.println(result);
    }



    public static FileVal parseInput(String st){
        String separator = ":";
        String lineInput[] = st.split(separator);

        FileVal newFile = new FileVal(lineInput[0],Long.parseLong(lineInput[1]));

        return  newFile;

    }

    public static List<List<FileRange>> getSplits(List<FileVal> files, int N){


          long totalLength = 0;
          for(FileVal temp : files)
              totalLength += temp.getLength();

          long fileRangeLength = totalLength /N;

          //Extra remaining length
          long additionalLength = totalLength % N;
          int index =0;
        long offset =0 ;

        List<List<FileRange>> Result = new ArrayList<List<FileRange>>() ;
          for (int i =0;i<N;i++){

              List<FileRange> threadFileRanges = new ArrayList<FileRange>();
              long newLength = (additionalLength-- > 0)? fileRangeLength+1 :fileRangeLength;
                long count= 0;

                int j;

              for( j= index;j<files.size();j++){

                  long fileLength =  files.get(j).getLength();

                  if(count + fileLength > newLength) break;
                  //If file can fit in this Thread
                  FileRange newFileRange = new FileRange();
                  newFileRange.setFilename(files.get(j).getFilename());
                  newFileRange.setStartOffSet(offset);
                  newFileRange.setEndOffSet(offset + files.get(j).getLength() -1);
                  System.out.println(newFileRange);
                  threadFileRanges.add(newFileRange);
                  count += fileLength;
                    offset =0;
                    index++;

                  }

              if(j < files.size() && newLength > count){
                  //If file length cannot fit in this Thread
                  long rangeLength = newLength - count;
                  long fileLength =  files.get(j).getLength();

                  FileRange newFileRange = new FileRange();
                  newFileRange.setFilename(files.get(j).getFilename());
                  newFileRange.setStartOffSet(offset);
                  newFileRange.setEndOffSet(offset + rangeLength -1);
                  System.out.println(newFileRange);
                  threadFileRanges.add(newFileRange);
                offset = offset + rangeLength;
                files.get(j).setLength(fileLength - rangeLength);
              }

            //  System.out.println(threadFileRanges);
              Result.add(threadFileRanges);
          }

        return Result;
    }



}
