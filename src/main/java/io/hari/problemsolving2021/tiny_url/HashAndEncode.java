package io.hari.problemsolving2021.tiny_url;

import lombok.SneakyThrows;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.util.Base64;

/**
 * @Author Hariom Yadav
 * @create 23-03-2021
 */
public class HashAndEncode {
    @SneakyThrows
    public static void main(String[] args) {
        //TODO : string -> md5 -> encode -> output ~21 char string
        //TODO :1 create a hash value of string using md5/sha256
        final String password = "password123";
        System.out.println("password = " + password);
        final byte[] hash = createHash(password.getBytes());
        final String hexBinary = DatatypeConverter.printHexBinary(hash);
        System.out.println("md5 output in hex = " + hexBinary);


        //todo :2 convert above hash value to encoded string using Base64
        //todo : encode hariom yadav ->
        String name = "hariom yadav";
        System.out.println("name = " + name);
        final byte[] nameBytes = name.getBytes();//A = 65, B = 66 ... a = 97, b = 98 ...
        printArray(nameBytes);
        final String encode = Base64.getEncoder().encodeToString(nameBytes);
        System.out.println("encode = " + encode);

        //TODO : decode encoded string back to hariom yadav
        final byte[] decode = Base64.getDecoder().decode(encode);
        final String nameDecode = new String(decode);
        System.out.println("nameDecode = " + nameDecode);

    }

    @SneakyThrows
    private static byte[] createHash(byte[] inputStrInBytes) {
        printArray(inputStrInBytes);
        final MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(inputStrInBytes);
        final byte[] digestInBytes = md5.digest();
        return digestInBytes;
    }

    private static void printArray(byte[] nameBytes) {
        for (int i = 0; i < nameBytes.length; i++) {
            System.out.print(nameBytes[i]+" ");
        }
        System.out.println();
    }
}
