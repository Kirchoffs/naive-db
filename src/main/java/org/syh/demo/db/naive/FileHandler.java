package org.syh.demo.db.naive;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileHandler {
    private RandomAccessFile dbFile;

    public FileHandler(final String dbFileName) throws FileNotFoundException {
        dbFile = new RandomAccessFile(dbFileName, "rw");
    }

    public boolean add(
            String name,
            int age,
            String address,
            String carPlateNumber,
            String description) throws IOException {
        // Go to the end of the file
        dbFile.seek(dbFile.length());

        // calculate the record length
        int length =
                4 +                       // name length
                name.length() +           // name
                4 +                       // age
                4 +                       // address length
                address.length() +        // address
                4 +                       // carPlateNumber length
                carPlateNumber.length() + // carPlateNumber
                4 +                       // description length
                description.length();     // description

        // isDeleted flag
        dbFile.writeBoolean(false);

        // record length: int
        dbFile.writeInt(length);

        // name length: int
        // name
        dbFile.writeInt(name.length());
        dbFile.write(name.getBytes());

        dbFile.writeInt(age);

        // address length: int
        // address
        dbFile.writeInt(address.length());
        dbFile.write(address.getBytes());

        // carPlateNumber length: int
        // cardPlateNumber
        dbFile.writeInt(carPlateNumber.length());
        dbFile.write(carPlateNumber.getBytes());

        // description length: int
        // description
        dbFile.writeInt(description.length());
        dbFile.write(description.getBytes());

        return true;
    }

    public void close() throws IOException {
        dbFile.close();
    }
}
