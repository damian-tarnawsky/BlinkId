package com.phonegap.plugins.microblink.recognizers.serialization;

import com.microblink.entities.recognizers.Recognizer;
import com.phonegap.plugins.microblink.recognizers.RecognizerSerialization;

import org.json.JSONException;
import org.json.JSONObject;

public final class SloveniaIdFrontRecognizerSerialization implements RecognizerSerialization {

    @Override
    public Recognizer<?, ?> createRecognizer(JSONObject jsonRecognizer) {
        com.microblink.entities.recognizers.blinkid.slovenia.SloveniaIdFrontRecognizer recognizer = new com.microblink.entities.recognizers.blinkid.slovenia.SloveniaIdFrontRecognizer();
        recognizer.setDetectGlare(jsonRecognizer.optBoolean("detectGlare", true));
        recognizer.setExtractDateOfBirth(jsonRecognizer.optBoolean("extractDateOfBirth", true));
        recognizer.setExtractDateOfExpiry(jsonRecognizer.optBoolean("extractDateOfExpiry", true));
        recognizer.setExtractNationality(jsonRecognizer.optBoolean("extractNationality", true));
        recognizer.setExtractSex(jsonRecognizer.optBoolean("extractSex", true));
        recognizer.setReturnFaceImage(jsonRecognizer.optBoolean("returnFaceImage", false));
        recognizer.setReturnFullDocumentImage(jsonRecognizer.optBoolean("returnFullDocumentImage", false));
        recognizer.setReturnSignatureImage(jsonRecognizer.optBoolean("returnSignatureImage", false));
        return recognizer;
    }

    @Override
    public JSONObject serializeResult(Recognizer<?, ?> recognizer) {
        com.microblink.entities.recognizers.blinkid.slovenia.SloveniaIdFrontRecognizer.Result result = ((com.microblink.entities.recognizers.blinkid.slovenia.SloveniaIdFrontRecognizer)recognizer).getResult();
        JSONObject jsonResult = new JSONObject();
        try {
            SerializationUtils.addCommonResultData(jsonResult, result);
            jsonResult.put("dateOfBirth", SerializationUtils.serializeDate(result.getDateOfBirth()));
            jsonResult.put("dateOfExpiry", SerializationUtils.serializeDate(result.getDateOfExpiry()));
            jsonResult.put("faceImage", SerializationUtils.encodeImageBase64(result.getFaceImage()));
            jsonResult.put("firstName", result.getFirstName());
            jsonResult.put("fullDocumentImage", SerializationUtils.encodeImageBase64(result.getFullDocumentImage()));
            jsonResult.put("lastName", result.getLastName());
            jsonResult.put("nationality", result.getNationality());
            jsonResult.put("sex", result.getSex());
            jsonResult.put("signatureImage", SerializationUtils.encodeImageBase64(result.getSignatureImage()));
        } catch (JSONException e) {
            // see https://developer.android.com/reference/org/json/JSONException
            throw new RuntimeException(e);
        }
        return jsonResult;
    }

    @Override
    public String getJsonName() {
        return "SloveniaIdFrontRecognizer";
    }

    @Override
    public Class<?> getRecognizerClass() {
        return com.microblink.entities.recognizers.blinkid.slovenia.SloveniaIdFrontRecognizer.class;
    }
}