package io.hari.problemsolving2021;

import java.util.*;

/**
 * @Author Hariom Yadav
 * @create 20-03-2021
 */
public class TestGrab {
    public static void main(String[] args) {
//        int[] arr = {3, 5, 6, 3, 3, 5};
//        solution(arr);

        Question4 question4 = new Question4();
        String S = "my.song.mp3 11b\ngreatSong.flac 1000b\nnot3.txt 5b\nvideo.mp4 200b\ngame.exe 100b\nmov!e.mkv 10000b";
        String S2 = "my.mp3.mp4.song.mp3 11b\ngreatSong.flac 1000b\nnot3.txt 5b\nvideo.mp4 200b\ngame.exe 100b\nmov!e.mp3.mkv 10000b";

        System.out.println(question4.solution(S));
        System.out.println(question4.solution(S2));

    }

    public static void solution(int[] A) {
        Arrays.sort(A);
        printArrays(A);
        int j = 0;
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (i == j) {
                j++;
            } else if (i < j && A[i] == A[j]) {
                count++;
                if (j + 1 < A.length && A[j] != A[j + 1]) {
                    j++;
                }
            }
        }
    }

    public static int countPairs(int arr[], int n) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (hm.containsKey(arr[i]))
                hm.put(arr[i], hm.get(arr[i]) + 1);
            else
                hm.put(arr[i], 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> it : hm.entrySet()) {
            int count = it.getValue();
            ans += (count * (count - 1)) / 2;
        }
        return ans;
    }


    public static void printArrays(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int solution2(int[] A) {
        long ans = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int k : A) {
            map.put(k, map.getOrDefault(k, 0) + 1);
        }

        for (int k : map.values()) {
            ans += ((long) k) * (k - 1) / 2;
        }
        return ans > 1000000000l ? 1000000000 : (int) ans;
    }

    private int findFileSize(String file) {
        String fileSize = file.split("\\s+")[1];
        return Integer.parseInt(fileSize.substring(0, fileSize.length() - 1));
    }

    public static class Question4 {

        public int findFileSize(String file) {
            String fileSize = file.split("\\s+")[1];
            return Integer.parseInt(fileSize.substring(0, fileSize.length() - 1));
        }

        public String solution(String S) {
            String[] files = S.split("\\r?\\n");
            long totalMovieSize = 0;
            long totalImageSize = 0;
            long totalMusicSize = 0;
            long totalOtherSize = 0;

            Set<String> mp3Extensions = new HashSet<>(Arrays.asList("mp3", "aac", "flac"));
            Set<String> imageExtensions = new HashSet<>(Arrays.asList("jpg", "bmp", "gif"));
            Set<String> mp4Extensions = new HashSet<>(Arrays.asList("mp4", "avi", "mkv"));

            for (String file : files) {
                String[] splited = file.split("\\s+");             //mov!e.mp3.mkv, 10000b
                final String finalFileName = splited[0];                //mov!e.mp3.mkv
                final String[] split = finalFileName.split("\\."); //mov!e, mp3, mkv
                final String fileExtension = split[split.length - 1];    //mkv

                if (mp3Extensions.contains(fileExtension)) {
                    int size = findFileSize(file);
                    totalMusicSize += size;
                }  //image
                else if (imageExtensions.contains(fileExtension)) {
                    int size = findFileSize(file);
                    totalImageSize += size;
                } //movie
                else if (mp4Extensions.contains(fileExtension)) {
                    int size = findFileSize(file);
                    totalMovieSize += size;
                } //other
                else {
                    int size = findFileSize(file);
                    totalOtherSize += size;
                }
            }
            String musicsFileSize = "music " + totalMusicSize + "b";
            String moviesFileSize = "movies " + totalMovieSize + "b";
            String imagesFileSize = "images " + totalImageSize + "b";
            String otherFileSize = "other " + totalOtherSize + "b";
            String allFiles = musicsFileSize + "\n" + imagesFileSize + "\n" + moviesFileSize + "\n" + otherFileSize;
            return allFiles;
        }
    }

}
