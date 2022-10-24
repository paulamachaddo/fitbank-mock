package com.br.sellers.fitbank.mock.service.paymentslip;

import com.br.sellers.fitbank.mock.gateway.model.request.BasicRequestModel;
import com.br.sellers.fitbank.mock.gateway.model.request.paymentslip.CancelPaymentSlipDetailsRequestModel;
import com.br.sellers.fitbank.mock.gateway.model.request.paymentslip.GetPaymentSlipDetailsRequestModel;
import com.br.sellers.fitbank.mock.gateway.model.response.BasicResponseModel;
import com.br.sellers.fitbank.mock.gateway.model.response.paymentslip.CancelPaymentSlipResponseModel;
import com.br.sellers.fitbank.mock.gateway.model.response.paymentslip.GetPaymentSlipDetailsItensResponseModel;
import com.br.sellers.fitbank.mock.gateway.model.response.paymentslip.GetPaymentSlipDetailsResponseModel;
import com.br.sellers.fitbank.mock.service.ServiceBaseImpl;
import com.google.gson.Gson;

import java.util.Map;

public class CancelPaymentSlipService extends ServiceBaseImpl {

    @Override
    protected BasicRequestModel toObject(String body) {
        return new Gson().fromJson(body, CancelPaymentSlipDetailsRequestModel.class);
    }

    @Override
    protected BasicResponseModel createResponse() {
        return new CancelPaymentSlipResponseModel();
    }

    @Override
    protected void sucess(BasicRequestModel request, BasicResponseModel response) {
    }

    @Override
    protected void validadeFields(BasicRequestModel request, Map<String, Object> errors) {
        GetPaymentSlipDetailsRequestModel model = (GetPaymentSlipDetailsRequestModel) request;
        validadeField(model.getDocumentNumber(), "DocumentNumber", "DocumentNumber é obrigatório", errors);
    }
}
