package com.common.dao.entity;

import com.common.baseDomain.Domain;
import java.math.BigDecimal;
import java.util.Date;

public class Test2 extends Domain {
    //uuid
    private String uuid;

    //选择
    private String x;

    //提示
    private String tip;

    //订单编号
    private String orderNumber;

    //外部平台单号
    private String externalPlatformSingleNumber;

    //是否锁定
    private Boolean isSticky;

    //仓库名称
    private String repositoryName;

    //付款状态
    private String payStatus;

    //支付宝交易号
    private String alipayTradingNo;

    //处理状态
    private String manageStates;

    //发货状态
    private String shippingStatus;

    //平台发货状态
    private String platformShippingStatus;

    //合并状态
    private String mergeState;

    //验货状态
    private String inspectionStatus;

    //验货员
    private String inspector;

    //验货日期
    private Date dateOfInspection;

    //外部订单状态
    private String externalOrderStatus;

    //订单类型
    private String orderType;

    //是否缺货
    private Boolean isItOutOfStock;

    //店铺名称
    private String shopName;

    //订单渠道
    private String orderChannels;

    //快递公司编号
    private String courierCompanyNo;

    //物流公司
    private String logisticsCompany;

    //菜鸟服务类型
    private String rookieServiceType;

    //菜鸟配送时间
    private Date rookieDeliveryTime;

    //快递公司名称
    private String nameOfCourierCompany;

    //快递链接
    private String courierLink;

    //快递单号
    private String trackingNumber;

    //买家ID
    private String buyerId;

    //买家留言
    private String customerMessage;

    //客服备注
    private String customerServiceNotes;

    //内部便签
    private String internalNotes;

    //其他备注
    private String otherNotes;

    //系统备注
    private String systemNotes;

    //是否挂起
    private Boolean whetherToSuspend;

    //挂起说明
    private String suspendInstructions;

    //挂起类型
    private String suspendType;

    //挂起时间
    private Date suspendTime;

    //挂起员
    private String suspended;

    //收货人
    private String receiver;

    //买家地址
    private String buyerAddress;

    //省
    private String province;

    //市
    private String city;

    //区
    private String zone;

    //产品总金额
    private BigDecimal totalAmountOfTheProduct;

    //实收金额
    private BigDecimal paidInAmount;

    //订单总金额
    private BigDecimal totalOrderAmount;

    //单品数量
    private Integer numberOfPosts;

    //单品条数
    private String numberOfSingleproductBars;

    //总件数
    private String totalNumberOfUnits;

    //总条数
    private String phIdmtc1Equivtextbase64jxmDiscountsInTotal;

    //颜色
    private String theColours;

    //实收快递费
    private String paidCourierFees;

    //实付快递费
    private String payinCourierFees;

    //快递代收金额
    private BigDecimal expressCollectionAmount;

    //电话
    private String tel;

    //手机
    private String mobilePhone;

    //电子邮件
    private String email;

    //订货日期
    private Date orderingDate;

    //获取时间
    private Date getTime;

    //付款日期
    private Date dayOfPayment;

    //打印日期
    private Date printDate;

    //预配货时间
    private Date predeliveryTime;

    //称重日期
    private Date weighingDate;

    //发货日期
    private Date shippingDate;

    //下单员
    private String theOrderer;

    //业务员
    private String salesOperator;

    //打印员
    private String printer;

    //审单员
    private String reviewer;

    //财审员
    private String financialExaminer;

    //预配货员
    private String preallocator;

    //配货员
    private String dispenser;

    //称重员
    private String weigher;

    //打包员
    private String packer;

    //到款员
    private String toTheClerk;

    //取消员
    private String canceler;

    //取消时间
    private Date cancelTime;

    //支付宝
    private String alipay;

    //审单时间
    private Date reviewTime;

    //财审时间
    private Date financialReviewTime;

    //经销商编号
    private String dealerNo;

    //分销商账号
    private String distributorAccountNumbers;

    //分销商名称
    private String distributorName;

    //订单净重
    private String netWeightOfOrders;

    //应收快递费
    private String expressChargesReceivable;

    //订单毛重
    private String orderGrossWeight;

    //应付快递费
    private String courierChargesPayable;

    //开发票
    private String invoiceTo;

    //新客户
    private String newCustomers;

    //锁定员
    private String lockman;

    //已打印
    private String printed;

    //是否货到付款
    private Boolean whetherToPayOnDelivery;

    //促销渠道
    private String promotionalChannels;

    //应收核销日期
    private Date arWriteoffDate;

    //应收核销金额
    private BigDecimal amountOfWriteoffReceivable;

    //快递核销日期
    private Date expressWriteoffDate;

    //快递核销金额
    private BigDecimal expressWriteoffAmount;

    //应付记账日期
    private Date bookPayableDate;

    //应收记账日期
    private Date accountsReceivableDate;

    //订单总优惠
    private String totalOffer;

    //整单优惠
    private String entireOffer;

    //排序
    private String sortedBy;

    //退款金额
    private BigDecimal refundAmount;

    //退货状态
    private String returnStatus;

    //退款状态
    private String refundStatus;

    //邮编
    private String postalCode;

    //签收时间
    private Date receivingTime;

    //省区域代码
    private String provincialCode;

    //市区域代码
    private String cityCode;

    //区县区域代码
    private String districtAreaCode;

    //代金券
    private String voucher;

    //红包
    private String redEnvelope;

    //积分
    private String points;

    //平台承担优惠合计
    private String totalBenefitsForPlatformStake;

    //优惠券
    private String coupons;

    //佣金
    private BigDecimal commission;

    //商家承担优惠合计
    private String merchantsTakeAdvantageOfTheTotal;

    //旗帜颜色
    private String flagColor;

    //打折金额
    private BigDecimal discountedAmount;

    //退货到货数量
    private Integer returnEdcomingQuantity;

    //订单促销信息
    private String orderPromotions;

    //体积
    private String volume;

    //发票抬头
    private String invoiceTitle;

    //仓库
    private String warehouse;

    //外部平台id号
    private String id;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x == null ? null : x.trim();
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip == null ? null : tip.trim();
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    public String getExternalPlatformSingleNumber() {
        return externalPlatformSingleNumber;
    }

    public void setExternalPlatformSingleNumber(String externalPlatformSingleNumber) {
        this.externalPlatformSingleNumber = externalPlatformSingleNumber == null ? null : externalPlatformSingleNumber.trim();
    }

    public Boolean getIsSticky() {
        return isSticky;
    }

    public void setIsSticky(Boolean isSticky) {
        this.isSticky = isSticky;
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName == null ? null : repositoryName.trim();
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus == null ? null : payStatus.trim();
    }

    public String getAlipayTradingNo() {
        return alipayTradingNo;
    }

    public void setAlipayTradingNo(String alipayTradingNo) {
        this.alipayTradingNo = alipayTradingNo == null ? null : alipayTradingNo.trim();
    }

    public String getManageStates() {
        return manageStates;
    }

    public void setManageStates(String manageStates) {
        this.manageStates = manageStates == null ? null : manageStates.trim();
    }

    public String getShippingStatus() {
        return shippingStatus;
    }

    public void setShippingStatus(String shippingStatus) {
        this.shippingStatus = shippingStatus == null ? null : shippingStatus.trim();
    }

    public String getPlatformShippingStatus() {
        return platformShippingStatus;
    }

    public void setPlatformShippingStatus(String platformShippingStatus) {
        this.platformShippingStatus = platformShippingStatus == null ? null : platformShippingStatus.trim();
    }

    public String getMergeState() {
        return mergeState;
    }

    public void setMergeState(String mergeState) {
        this.mergeState = mergeState == null ? null : mergeState.trim();
    }

    public String getInspectionStatus() {
        return inspectionStatus;
    }

    public void setInspectionStatus(String inspectionStatus) {
        this.inspectionStatus = inspectionStatus == null ? null : inspectionStatus.trim();
    }

    public String getInspector() {
        return inspector;
    }

    public void setInspector(String inspector) {
        this.inspector = inspector == null ? null : inspector.trim();
    }

    public Date getDateOfInspection() {
        return dateOfInspection;
    }

    public void setDateOfInspection(Date dateOfInspection) {
        this.dateOfInspection = dateOfInspection;
    }

    public String getExternalOrderStatus() {
        return externalOrderStatus;
    }

    public void setExternalOrderStatus(String externalOrderStatus) {
        this.externalOrderStatus = externalOrderStatus == null ? null : externalOrderStatus.trim();
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType == null ? null : orderType.trim();
    }

    public Boolean getIsItOutOfStock() {
        return isItOutOfStock;
    }

    public void setIsItOutOfStock(Boolean isItOutOfStock) {
        this.isItOutOfStock = isItOutOfStock;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    public String getOrderChannels() {
        return orderChannels;
    }

    public void setOrderChannels(String orderChannels) {
        this.orderChannels = orderChannels == null ? null : orderChannels.trim();
    }

    public String getCourierCompanyNo() {
        return courierCompanyNo;
    }

    public void setCourierCompanyNo(String courierCompanyNo) {
        this.courierCompanyNo = courierCompanyNo == null ? null : courierCompanyNo.trim();
    }

    public String getLogisticsCompany() {
        return logisticsCompany;
    }

    public void setLogisticsCompany(String logisticsCompany) {
        this.logisticsCompany = logisticsCompany == null ? null : logisticsCompany.trim();
    }

    public String getRookieServiceType() {
        return rookieServiceType;
    }

    public void setRookieServiceType(String rookieServiceType) {
        this.rookieServiceType = rookieServiceType == null ? null : rookieServiceType.trim();
    }

    public Date getRookieDeliveryTime() {
        return rookieDeliveryTime;
    }

    public void setRookieDeliveryTime(Date rookieDeliveryTime) {
        this.rookieDeliveryTime = rookieDeliveryTime;
    }

    public String getNameOfCourierCompany() {
        return nameOfCourierCompany;
    }

    public void setNameOfCourierCompany(String nameOfCourierCompany) {
        this.nameOfCourierCompany = nameOfCourierCompany == null ? null : nameOfCourierCompany.trim();
    }

    public String getCourierLink() {
        return courierLink;
    }

    public void setCourierLink(String courierLink) {
        this.courierLink = courierLink == null ? null : courierLink.trim();
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber == null ? null : trackingNumber.trim();
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId == null ? null : buyerId.trim();
    }

    public String getCustomerMessage() {
        return customerMessage;
    }

    public void setCustomerMessage(String customerMessage) {
        this.customerMessage = customerMessage == null ? null : customerMessage.trim();
    }

    public String getCustomerServiceNotes() {
        return customerServiceNotes;
    }

    public void setCustomerServiceNotes(String customerServiceNotes) {
        this.customerServiceNotes = customerServiceNotes == null ? null : customerServiceNotes.trim();
    }

    public String getInternalNotes() {
        return internalNotes;
    }

    public void setInternalNotes(String internalNotes) {
        this.internalNotes = internalNotes == null ? null : internalNotes.trim();
    }

    public String getOtherNotes() {
        return otherNotes;
    }

    public void setOtherNotes(String otherNotes) {
        this.otherNotes = otherNotes == null ? null : otherNotes.trim();
    }

    public String getSystemNotes() {
        return systemNotes;
    }

    public void setSystemNotes(String systemNotes) {
        this.systemNotes = systemNotes == null ? null : systemNotes.trim();
    }

    public Boolean getWhetherToSuspend() {
        return whetherToSuspend;
    }

    public void setWhetherToSuspend(Boolean whetherToSuspend) {
        this.whetherToSuspend = whetherToSuspend;
    }

    public String getSuspendInstructions() {
        return suspendInstructions;
    }

    public void setSuspendInstructions(String suspendInstructions) {
        this.suspendInstructions = suspendInstructions == null ? null : suspendInstructions.trim();
    }

    public String getSuspendType() {
        return suspendType;
    }

    public void setSuspendType(String suspendType) {
        this.suspendType = suspendType == null ? null : suspendType.trim();
    }

    public Date getSuspendTime() {
        return suspendTime;
    }

    public void setSuspendTime(Date suspendTime) {
        this.suspendTime = suspendTime;
    }

    public String getSuspended() {
        return suspended;
    }

    public void setSuspended(String suspended) {
        this.suspended = suspended == null ? null : suspended.trim();
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver == null ? null : receiver.trim();
    }

    public String getBuyerAddress() {
        return buyerAddress;
    }

    public void setBuyerAddress(String buyerAddress) {
        this.buyerAddress = buyerAddress == null ? null : buyerAddress.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone == null ? null : zone.trim();
    }

    public BigDecimal getTotalAmountOfTheProduct() {
        return totalAmountOfTheProduct;
    }

    public void setTotalAmountOfTheProduct(BigDecimal totalAmountOfTheProduct) {
        this.totalAmountOfTheProduct = totalAmountOfTheProduct;
    }

    public BigDecimal getPaidInAmount() {
        return paidInAmount;
    }

    public void setPaidInAmount(BigDecimal paidInAmount) {
        this.paidInAmount = paidInAmount;
    }

    public BigDecimal getTotalOrderAmount() {
        return totalOrderAmount;
    }

    public void setTotalOrderAmount(BigDecimal totalOrderAmount) {
        this.totalOrderAmount = totalOrderAmount;
    }

    public Integer getNumberOfPosts() {
        return numberOfPosts;
    }

    public void setNumberOfPosts(Integer numberOfPosts) {
        this.numberOfPosts = numberOfPosts;
    }

    public String getNumberOfSingleproductBars() {
        return numberOfSingleproductBars;
    }

    public void setNumberOfSingleproductBars(String numberOfSingleproductBars) {
        this.numberOfSingleproductBars = numberOfSingleproductBars == null ? null : numberOfSingleproductBars.trim();
    }

    public String getTotalNumberOfUnits() {
        return totalNumberOfUnits;
    }

    public void setTotalNumberOfUnits(String totalNumberOfUnits) {
        this.totalNumberOfUnits = totalNumberOfUnits == null ? null : totalNumberOfUnits.trim();
    }

    public String getPhIdmtc1Equivtextbase64jxmDiscountsInTotal() {
        return phIdmtc1Equivtextbase64jxmDiscountsInTotal;
    }

    public void setPhIdmtc1Equivtextbase64jxmDiscountsInTotal(String phIdmtc1Equivtextbase64jxmDiscountsInTotal) {
        this.phIdmtc1Equivtextbase64jxmDiscountsInTotal = phIdmtc1Equivtextbase64jxmDiscountsInTotal == null ? null : phIdmtc1Equivtextbase64jxmDiscountsInTotal.trim();
    }

    public String getTheColours() {
        return theColours;
    }

    public void setTheColours(String theColours) {
        this.theColours = theColours == null ? null : theColours.trim();
    }

    public String getPaidCourierFees() {
        return paidCourierFees;
    }

    public void setPaidCourierFees(String paidCourierFees) {
        this.paidCourierFees = paidCourierFees == null ? null : paidCourierFees.trim();
    }

    public String getPayinCourierFees() {
        return payinCourierFees;
    }

    public void setPayinCourierFees(String payinCourierFees) {
        this.payinCourierFees = payinCourierFees == null ? null : payinCourierFees.trim();
    }

    public BigDecimal getExpressCollectionAmount() {
        return expressCollectionAmount;
    }

    public void setExpressCollectionAmount(BigDecimal expressCollectionAmount) {
        this.expressCollectionAmount = expressCollectionAmount;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Date getOrderingDate() {
        return orderingDate;
    }

    public void setOrderingDate(Date orderingDate) {
        this.orderingDate = orderingDate;
    }

    public Date getGetTime() {
        return getTime;
    }

    public void setGetTime(Date getTime) {
        this.getTime = getTime;
    }

    public Date getDayOfPayment() {
        return dayOfPayment;
    }

    public void setDayOfPayment(Date dayOfPayment) {
        this.dayOfPayment = dayOfPayment;
    }

    public Date getPrintDate() {
        return printDate;
    }

    public void setPrintDate(Date printDate) {
        this.printDate = printDate;
    }

    public Date getPredeliveryTime() {
        return predeliveryTime;
    }

    public void setPredeliveryTime(Date predeliveryTime) {
        this.predeliveryTime = predeliveryTime;
    }

    public Date getWeighingDate() {
        return weighingDate;
    }

    public void setWeighingDate(Date weighingDate) {
        this.weighingDate = weighingDate;
    }

    public Date getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(Date shippingDate) {
        this.shippingDate = shippingDate;
    }

    public String getTheOrderer() {
        return theOrderer;
    }

    public void setTheOrderer(String theOrderer) {
        this.theOrderer = theOrderer == null ? null : theOrderer.trim();
    }

    public String getSalesOperator() {
        return salesOperator;
    }

    public void setSalesOperator(String salesOperator) {
        this.salesOperator = salesOperator == null ? null : salesOperator.trim();
    }

    public String getPrinter() {
        return printer;
    }

    public void setPrinter(String printer) {
        this.printer = printer == null ? null : printer.trim();
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer == null ? null : reviewer.trim();
    }

    public String getFinancialExaminer() {
        return financialExaminer;
    }

    public void setFinancialExaminer(String financialExaminer) {
        this.financialExaminer = financialExaminer == null ? null : financialExaminer.trim();
    }

    public String getPreallocator() {
        return preallocator;
    }

    public void setPreallocator(String preallocator) {
        this.preallocator = preallocator == null ? null : preallocator.trim();
    }

    public String getDispenser() {
        return dispenser;
    }

    public void setDispenser(String dispenser) {
        this.dispenser = dispenser == null ? null : dispenser.trim();
    }

    public String getWeigher() {
        return weigher;
    }

    public void setWeigher(String weigher) {
        this.weigher = weigher == null ? null : weigher.trim();
    }

    public String getPacker() {
        return packer;
    }

    public void setPacker(String packer) {
        this.packer = packer == null ? null : packer.trim();
    }

    public String getToTheClerk() {
        return toTheClerk;
    }

    public void setToTheClerk(String toTheClerk) {
        this.toTheClerk = toTheClerk == null ? null : toTheClerk.trim();
    }

    public String getCanceler() {
        return canceler;
    }

    public void setCanceler(String canceler) {
        this.canceler = canceler == null ? null : canceler.trim();
    }

    public Date getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(Date cancelTime) {
        this.cancelTime = cancelTime;
    }

    public String getAlipay() {
        return alipay;
    }

    public void setAlipay(String alipay) {
        this.alipay = alipay == null ? null : alipay.trim();
    }

    public Date getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(Date reviewTime) {
        this.reviewTime = reviewTime;
    }

    public Date getFinancialReviewTime() {
        return financialReviewTime;
    }

    public void setFinancialReviewTime(Date financialReviewTime) {
        this.financialReviewTime = financialReviewTime;
    }

    public String getDealerNo() {
        return dealerNo;
    }

    public void setDealerNo(String dealerNo) {
        this.dealerNo = dealerNo == null ? null : dealerNo.trim();
    }

    public String getDistributorAccountNumbers() {
        return distributorAccountNumbers;
    }

    public void setDistributorAccountNumbers(String distributorAccountNumbers) {
        this.distributorAccountNumbers = distributorAccountNumbers == null ? null : distributorAccountNumbers.trim();
    }

    public String getDistributorName() {
        return distributorName;
    }

    public void setDistributorName(String distributorName) {
        this.distributorName = distributorName == null ? null : distributorName.trim();
    }

    public String getNetWeightOfOrders() {
        return netWeightOfOrders;
    }

    public void setNetWeightOfOrders(String netWeightOfOrders) {
        this.netWeightOfOrders = netWeightOfOrders == null ? null : netWeightOfOrders.trim();
    }

    public String getExpressChargesReceivable() {
        return expressChargesReceivable;
    }

    public void setExpressChargesReceivable(String expressChargesReceivable) {
        this.expressChargesReceivable = expressChargesReceivable == null ? null : expressChargesReceivable.trim();
    }

    public String getOrderGrossWeight() {
        return orderGrossWeight;
    }

    public void setOrderGrossWeight(String orderGrossWeight) {
        this.orderGrossWeight = orderGrossWeight == null ? null : orderGrossWeight.trim();
    }

    public String getCourierChargesPayable() {
        return courierChargesPayable;
    }

    public void setCourierChargesPayable(String courierChargesPayable) {
        this.courierChargesPayable = courierChargesPayable == null ? null : courierChargesPayable.trim();
    }

    public String getInvoiceTo() {
        return invoiceTo;
    }

    public void setInvoiceTo(String invoiceTo) {
        this.invoiceTo = invoiceTo == null ? null : invoiceTo.trim();
    }

    public String getNewCustomers() {
        return newCustomers;
    }

    public void setNewCustomers(String newCustomers) {
        this.newCustomers = newCustomers == null ? null : newCustomers.trim();
    }

    public String getLockman() {
        return lockman;
    }

    public void setLockman(String lockman) {
        this.lockman = lockman == null ? null : lockman.trim();
    }

    public String getPrinted() {
        return printed;
    }

    public void setPrinted(String printed) {
        this.printed = printed == null ? null : printed.trim();
    }

    public Boolean getWhetherToPayOnDelivery() {
        return whetherToPayOnDelivery;
    }

    public void setWhetherToPayOnDelivery(Boolean whetherToPayOnDelivery) {
        this.whetherToPayOnDelivery = whetherToPayOnDelivery;
    }

    public String getPromotionalChannels() {
        return promotionalChannels;
    }

    public void setPromotionalChannels(String promotionalChannels) {
        this.promotionalChannels = promotionalChannels == null ? null : promotionalChannels.trim();
    }

    public Date getArWriteoffDate() {
        return arWriteoffDate;
    }

    public void setArWriteoffDate(Date arWriteoffDate) {
        this.arWriteoffDate = arWriteoffDate;
    }

    public BigDecimal getAmountOfWriteoffReceivable() {
        return amountOfWriteoffReceivable;
    }

    public void setAmountOfWriteoffReceivable(BigDecimal amountOfWriteoffReceivable) {
        this.amountOfWriteoffReceivable = amountOfWriteoffReceivable;
    }

    public Date getExpressWriteoffDate() {
        return expressWriteoffDate;
    }

    public void setExpressWriteoffDate(Date expressWriteoffDate) {
        this.expressWriteoffDate = expressWriteoffDate;
    }

    public BigDecimal getExpressWriteoffAmount() {
        return expressWriteoffAmount;
    }

    public void setExpressWriteoffAmount(BigDecimal expressWriteoffAmount) {
        this.expressWriteoffAmount = expressWriteoffAmount;
    }

    public Date getBookPayableDate() {
        return bookPayableDate;
    }

    public void setBookPayableDate(Date bookPayableDate) {
        this.bookPayableDate = bookPayableDate;
    }

    public Date getAccountsReceivableDate() {
        return accountsReceivableDate;
    }

    public void setAccountsReceivableDate(Date accountsReceivableDate) {
        this.accountsReceivableDate = accountsReceivableDate;
    }

    public String getTotalOffer() {
        return totalOffer;
    }

    public void setTotalOffer(String totalOffer) {
        this.totalOffer = totalOffer == null ? null : totalOffer.trim();
    }

    public String getEntireOffer() {
        return entireOffer;
    }

    public void setEntireOffer(String entireOffer) {
        this.entireOffer = entireOffer == null ? null : entireOffer.trim();
    }

    public String getSortedBy() {
        return sortedBy;
    }

    public void setSortedBy(String sortedBy) {
        this.sortedBy = sortedBy == null ? null : sortedBy.trim();
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(String returnStatus) {
        this.returnStatus = returnStatus == null ? null : returnStatus.trim();
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus == null ? null : refundStatus.trim();
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode == null ? null : postalCode.trim();
    }

    public Date getReceivingTime() {
        return receivingTime;
    }

    public void setReceivingTime(Date receivingTime) {
        this.receivingTime = receivingTime;
    }

    public String getProvincialCode() {
        return provincialCode;
    }

    public void setProvincialCode(String provincialCode) {
        this.provincialCode = provincialCode == null ? null : provincialCode.trim();
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    public String getDistrictAreaCode() {
        return districtAreaCode;
    }

    public void setDistrictAreaCode(String districtAreaCode) {
        this.districtAreaCode = districtAreaCode == null ? null : districtAreaCode.trim();
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher == null ? null : voucher.trim();
    }

    public String getRedEnvelope() {
        return redEnvelope;
    }

    public void setRedEnvelope(String redEnvelope) {
        this.redEnvelope = redEnvelope == null ? null : redEnvelope.trim();
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points == null ? null : points.trim();
    }

    public String getTotalBenefitsForPlatformStake() {
        return totalBenefitsForPlatformStake;
    }

    public void setTotalBenefitsForPlatformStake(String totalBenefitsForPlatformStake) {
        this.totalBenefitsForPlatformStake = totalBenefitsForPlatformStake == null ? null : totalBenefitsForPlatformStake.trim();
    }

    public String getCoupons() {
        return coupons;
    }

    public void setCoupons(String coupons) {
        this.coupons = coupons == null ? null : coupons.trim();
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public String getMerchantsTakeAdvantageOfTheTotal() {
        return merchantsTakeAdvantageOfTheTotal;
    }

    public void setMerchantsTakeAdvantageOfTheTotal(String merchantsTakeAdvantageOfTheTotal) {
        this.merchantsTakeAdvantageOfTheTotal = merchantsTakeAdvantageOfTheTotal == null ? null : merchantsTakeAdvantageOfTheTotal.trim();
    }

    public String getFlagColor() {
        return flagColor;
    }

    public void setFlagColor(String flagColor) {
        this.flagColor = flagColor == null ? null : flagColor.trim();
    }

    public BigDecimal getDiscountedAmount() {
        return discountedAmount;
    }

    public void setDiscountedAmount(BigDecimal discountedAmount) {
        this.discountedAmount = discountedAmount;
    }

    public Integer getReturnEdcomingQuantity() {
        return returnEdcomingQuantity;
    }

    public void setReturnEdcomingQuantity(Integer returnEdcomingQuantity) {
        this.returnEdcomingQuantity = returnEdcomingQuantity;
    }

    public String getOrderPromotions() {
        return orderPromotions;
    }

    public void setOrderPromotions(String orderPromotions) {
        this.orderPromotions = orderPromotions == null ? null : orderPromotions.trim();
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume == null ? null : volume.trim();
    }

    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle == null ? null : invoiceTitle.trim();
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse == null ? null : warehouse.trim();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }
}