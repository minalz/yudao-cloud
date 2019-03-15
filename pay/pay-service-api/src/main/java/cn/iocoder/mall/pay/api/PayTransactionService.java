package cn.iocoder.mall.pay.api;

import cn.iocoder.common.framework.vo.CommonResult;
import cn.iocoder.mall.pay.api.bo.PayTransactionBO;
import cn.iocoder.mall.pay.api.bo.PayTransactionSubmitBO;
import cn.iocoder.mall.pay.api.dto.PayTransactionCreateDTO;
import cn.iocoder.mall.pay.api.dto.PayTransactionSubmitDTO;

public interface PayTransactionService {

    CommonResult<PayTransactionBO> createTransaction(PayTransactionCreateDTO payTransactionCreateDTO);

    CommonResult<PayTransactionSubmitBO> submitTransaction(PayTransactionSubmitDTO payTransactionSubmitDTO);

    /**
     * 更新交易支付成功
     *
     * 该接口用于不同支付平台，支付成功后，回调该接口
     *
     * @param payChannel 支付渠道
     * @param params 回调参数。
     *               因为不同平台，能够提供的参数不同，所以使用 String 类型统一接收，然后在使用不同的 AbstractPaySDK 进行处理。
     * @return 是否支付成功
     */
    CommonResult<Boolean> updateTransactionPaySuccess(Integer payChannel, String params);

    CommonResult cancelTransaction(); // TODO 1. params 2. result

}