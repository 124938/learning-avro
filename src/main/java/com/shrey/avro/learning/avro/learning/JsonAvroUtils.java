package com.shrey.avro.learning.avro.learning;

import org.apache.avro.Schema;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumWriter;
import tech.allegro.schema.json2avro.converter.JsonAvroConverter;

import java.io.FileOutputStream;
import java.io.IOException;

public class JsonAvroUtils {

    // Json to Avro converter
    private static final JsonAvroConverter converter = new JsonAvroConverter();

    public static byte[] toAvroBytes(final String schema, final String json) {
        // conversion to binary Avro
        return converter.convertToAvro(json.getBytes(), schema);
    }

    public static GenericData.Record toAvroRecord(final String schema, final String json) {
        // conversion to GenericData.Record
        return converter.convertToGenericDataRecord(json.getBytes(), new Schema.Parser().parse(schema));
    }

    public static String toJson(final byte[] avro, final String schema) {
        // conversion to GenericData.Record
        return new String(converter.convertToJson(avro, schema));
    }

    public static void writeAvroFile(final String schema, final GenericData.Record record, final String avroFilePath) {

        // Create instance of Data file writer
        DataFileWriter<GenericRecord> dataFileWriter = null;
        try {
            // Create instance of AVRO schema
            Schema avroSchema = new Schema.Parser().parse(schema);

            // Create instance of data file writer
            dataFileWriter = new DataFileWriter<GenericRecord>(new GenericDatumWriter<GenericRecord>(avroSchema));

            // Create file
            dataFileWriter.create(avroSchema, new FileOutputStream(avroFilePath));

            // Append data
            dataFileWriter.append(record);
        } catch (IOException e) {
            throw new RuntimeException("Unable to write AVRO file", e);
        } finally {
            if(dataFileWriter != null) {
                try {
                    dataFileWriter.close();
                } catch (IOException e) {
                    throw new RuntimeException("Unable to close data file writer", e);
                }
            }
        }
    }
}
