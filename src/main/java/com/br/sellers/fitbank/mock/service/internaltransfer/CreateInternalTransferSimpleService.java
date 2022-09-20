package com.br.sellers.fitbank.mock.service.internaltransfer;

import com.br.sellers.fitbank.mock.gateway.model.request.BasicRequestModel;
import com.br.sellers.fitbank.mock.gateway.model.request.internaltransfer.InternalTransferSimpleRequestModel;
import com.br.sellers.fitbank.mock.gateway.model.response.BasicResponseModel;
import com.br.sellers.fitbank.mock.gateway.model.response.internaltransfer.InternalTransferDestinyResponseModel;
import com.br.sellers.fitbank.mock.gateway.model.response.internaltransfer.InternalTransferResponseModel;
import com.br.sellers.fitbank.mock.service.ServiceBaseImpl;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateInternalTransferSimpleService extends ServiceBaseImpl {

    @Override
    protected BasicRequestModel toObject(String body) {
        return new Gson().fromJson(body, InternalTransferSimpleRequestModel.class);
    }

    @Override
    protected BasicResponseModel createResponse() {
        return new InternalTransferResponseModel();
    }

    @Override
    protected void sucess(BasicRequestModel request, BasicResponseModel response) {
        InternalTransferResponseModel modelResponde = (InternalTransferResponseModel) response;
        int value = new Random().nextInt(5000);
        modelResponde.setDocumentNumber(new Long(value));

        List<InternalTransferDestinyResponseModel> list = new ArrayList<>();
        InternalTransferDestinyResponseModel destiny = new InternalTransferDestinyResponseModel();
        destiny.setSuccess(true);
        destiny.setDocumentNumber(new Long(value));

        list.add(destiny);

        modelResponde.setInternalTransfers(new Gson().toJson(list));
    }

}
