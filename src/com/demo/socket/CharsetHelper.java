package com.demo.socket;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * @author csq
 * @date 2020/4/23 11:45
 * @description
 **/
public class CharsetHelper {

    private static final String UTF_8 = "UTF-8";
    private static CharsetEncoder encoder = Charset.forName(UTF_8).newEncoder();
    private static CharsetDecoder decoder = Charset.forName(UTF_8).newDecoder();

    private CharsetHelper() {
    }

    public static CharBuffer decode(ByteBuffer buffer) throws CharacterCodingException {
        return decoder.decode(buffer);
    }

    public static ByteBuffer encode(CharBuffer wrap) throws CharacterCodingException {
        return encoder.encode(wrap);
    }
}
