package cn.dlj1.world;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class RandomAccessFileDemo {

    public static void main(String[] args) throws IOException, InterruptedException {
        RandomAccessFile file = new RandomAccessFile("/Users/fivewords/Desktop/test","rw");

        FileChannel channel = file.getChannel();

        FileLock fileLock = channel.tryLock();

        Thread.sleep(10000);
        fileLock.release();


        channel.close();

        file.close();

    }

}
