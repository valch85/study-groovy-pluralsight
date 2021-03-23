BigDecimal value;

try{
    value = divide(1);
}catch(ArithmeticException ex){
//    def frames = ex.getStackTrace().toString().split(',');
//    for(frame in frames){
//        println(frame);
//    }
//
    value = 0;
}
catch(ex){
    value = 2;
}

BigDecimal divide(int x){
        throw new RuntimeException("other exception");
        def y = x/0;

        return y;
}