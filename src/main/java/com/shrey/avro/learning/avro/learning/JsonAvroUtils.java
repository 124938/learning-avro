package com.shrey.avro.learning.avro.learning;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import tech.allegro.schema.json2avro.converter.JsonAvroConverter;

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
}
