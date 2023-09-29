
public interface Pagamento {
    void onPagamentoRealizado(PagamentoDTO pagamento);

    void onPagamentoFalhado(PagamentoDTO pagamento);
}
