/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH_Phan02;
import java.io.IOException;
import java.nio.file.*;
import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

/**
 *
 * @author Admin
 */
public class MainClass_Bai5 {

    public MainClass_Bai5() {
    }
    
    private static class MyWatchQueueReader implements Runnable {
        
        private WatchService myWatcher;
        public MyWatchQueueReader(WatchService myWatcher) {
            this.myWatcher = myWatcher;
        }

        @Override
        public void run() {
            try {
            WatchKey key = myWatcher.take();
            while (key != null) {
            // we have a polled event, now we traverse it and
            // receive all the states from it
            for (WatchEvent event : key.pollEvents()) {
                System.out.printf("Received %s event for file: %s\n",
                event.kind(), event.context());
            }
            key.reset();
            key = myWatcher.take();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Stopping thread");
        }
    }
    public static final String DIRECTORY_TO_WATCH = "/Home/test";
    public static void main(String[] args) throws Exception {
        // get the directory we want to watch, using the Paths singleton class
        Path toWatch = null;
        try {
            toWatch = Paths.get(DIRECTORY_TO_WATCH);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (toWatch == null) {
            throw new UnsupportedOperationException("Không tìm thấy thư mục");
        }
        // make a new watch service that we can register interest in
        // directories and files with.
        WatchService myWatcher = toWatch.getFileSystem().newWatchService();
        // start the file watcher thread below
        MyWatchQueueReader fileWatcher = new MyWatchQueueReader(myWatcher);
        Thread th = new Thread(fileWatcher, "FileWatcher");
        th.start();
        // register a file
        toWatch.register(myWatcher, ENTRY_CREATE, ENTRY_MODIFY);
        th.join();
    }
}
