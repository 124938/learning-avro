package com.shrey.avro.learning;

import com.shrey.avro.learning.avro.learning.JsonAvroUtils;
import org.apache.avro.generic.GenericData;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonAvroUtilsTest {

    @Test
    public void test1() throws Exception {
        // Read Schema
        String schema = new String(Files.readAllBytes(Paths.get("./src/test/resources/test1.avsc")));

        // Read JSON
        String json = new String(Files.readAllBytes(Paths.get("./src/test/resources/test1.json")));

        // Generate AVRO record from JSON
        GenericData.Record avroData = JsonAvroUtils.toAvroRecord(schema, json);
        System.out.println("AVRO : "+avroData);
        Assert.assertNotNull(avroData);

        // Generate JSON
        String jsonData = JsonAvroUtils.toJson(JsonAvroUtils.toAvroBytes(schema, json), schema);
        System.out.println("JSON : "+jsonData);
        Assert.assertNotNull(jsonData);

        // Write AVRO file
        JsonAvroUtils.writeAvroFile(schema, avroData, "src/test/resources/test1_"+System.currentTimeMillis()+".avro");
    }

    @Test
    public void test2() throws Exception {
        // Read Schema
        String schema = new String(Files.readAllBytes(Paths.get("./src/test/resources/test2.avsc")));

        // Read JSON
        String json = new String(Files.readAllBytes(Paths.get("./src/test/resources/test2.json")));

        // Generate AVRO record from JSON
        GenericData.Record avroData = JsonAvroUtils.toAvroRecord(schema, json);
        System.out.println("AVRO : "+avroData);
        Assert.assertNotNull(avroData);

        // Generate JSON
        String jsonData = JsonAvroUtils.toJson(JsonAvroUtils.toAvroBytes(schema, json), schema);
        System.out.println("JSON : "+jsonData);
        Assert.assertNotNull(jsonData);

        // Write AVRO file
        JsonAvroUtils.writeAvroFile(schema, avroData, "src/test/resources/test2_"+System.currentTimeMillis()+".avro");
    }

    @Test
    public void test3() throws Exception {
        // Read Schema
        String schema = new String(Files.readAllBytes(Paths.get("./src/test/resources/test3.avsc")));

        // Read JSON
        String json = new String(Files.readAllBytes(Paths.get("./src/test/resources/test3.json")));

        // Generate AVRO record from JSON
        GenericData.Record avroData = JsonAvroUtils.toAvroRecord(schema, json);
        System.out.println("AVRO : "+avroData);
        Assert.assertNotNull(avroData);

        // Generate JSON
        String jsonData = JsonAvroUtils.toJson(JsonAvroUtils.toAvroBytes(schema, json), schema);
        System.out.println("JSON : "+jsonData);
        Assert.assertNotNull(jsonData);

        // Write AVRO file
        JsonAvroUtils.writeAvroFile(schema, avroData, "src/test/resources/test3_"+System.currentTimeMillis()+".avro");
    }
}
