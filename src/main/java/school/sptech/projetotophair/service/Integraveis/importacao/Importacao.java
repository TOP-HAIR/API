    package school.sptech.projetotophair.service.Integraveis.importacao;

    import org.springframework.web.multipart.MultipartFile;
    import school.sptech.projetotophair.domain.empresa.Empresa;
    import school.sptech.projetotophair.domain.usuario.Usuario;
    import school.sptech.projetotophair.service.EmpresaService;
    import school.sptech.projetotophair.service.UsuarioService;
    import school.sptech.projetotophair.service.dto.usuario.UsuarioCriacaoDto;
    import school.sptech.projetotophair.service.dto.usuario.mapper.UsuarioMapper;

    import java.io.*;
    import java.time.format.DateTimeFormatter;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Optional;

    public class Importacao {
        private final EmpresaService empresaService;
        private final UsuarioService usuarioService;
        public Importacao(EmpresaService empresaService, UsuarioService usuarioService) {
            this.empresaService = empresaService;
            this.usuarioService = usuarioService;
        }

        public List<UsuarioCriacaoDto> importarDados(MultipartFile file) {
            List<UsuarioCriacaoDto> listaUsuarios = new ArrayList<>();
            List<Empresa> listaEmpresas = new ArrayList<>();

            try (BufferedReader entrada = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
                String registro;
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                while ((registro = entrada.readLine()) != null) {
                    String tipoRegistro = registro.substring(0, 2);

                    if (tipoRegistro.equals("02")) {
                        UsuarioCriacaoDto usuario = new UsuarioCriacaoDto();

                        long id = Long.parseLong(registro.substring(2, 8).trim());
                        System.out.println(registro.substring(2, 8).trim());

                        String nomeCompleto = registro.substring(8, 58).trim();
                        System.out.println(registro.substring(8, 58).trim());

                        String email = registro.substring(58, 108).trim();
                        System.out.println(registro.substring(58, 108).trim());

                        String telefone = registro.substring(108, 122).trim();
                        System.out.println(registro.substring(108, 122).trim());

                        String cpf = registro.substring(122, 136).trim();
                        System.out.println(registro.substring(122, 136).trim());

                        Boolean isProfissional = registro.substring(136, 137).equals("t");
                        System.out.println(registro.substring(136, 137).trim());

                        long idEmpresa = Long.parseLong(registro.substring(137, 143).trim());
                        System.out.println(idEmpresa);
                        System.out.println(registro.substring(137, 143).trim());


                        usuario.setIdUsuario(id);
                        usuario.setNomeCompleto(nomeCompleto);
                        usuario.setEmail(email);
                        usuario.setTelefone(telefone);
                        usuario.setCpf(cpf);
                        usuario.setSenha("senhaPadrao123");
                        usuario.setProfissional(isProfissional);
                        Optional<Empresa> empresaOptional = empresaService.buscarEmpresaPorId(idEmpresa);
                            Empresa empresa = empresaOptional.orElse(null);

                        usuario.setEmpresa(empresa);
                        System.out.println(usuario);
                        listaUsuarios.add(usuario);
                    } else if (tipoRegistro.equals("03")) {
                        Empresa empresa = new Empresa();

                        long idEmpresa = Long.parseLong(registro.substring(2, 7).trim());
                        System.out.println(registro.substring(2, 7).trim());
                        String razaoSocial = registro.substring(7, 57).trim();
                        String cnpj = registro.substring(57, 75).trim();

                        empresa.setIdEmpresa(idEmpresa);
                        empresa.setRazaoSocial(razaoSocial);
                        empresa.setCnpj(cnpj);
                        listaEmpresas.add(empresa);
                    } else {
                        System.out.println("Tipo de registro indevido: " + registro);
                    }
                }
            } catch (IOException e) {
                System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            }

            // Processar os dados de empresas e associá-los aos usuários
            for (UsuarioCriacaoDto usuario : listaUsuarios) {
                for (Empresa empresa : listaEmpresas) {
                    if (usuario.getEmpresa().getIdEmpresa() == empresa.getIdEmpresa()) {
                        System.out.println("Entrou aqui");
                        usuario.setEmpresa(empresa);
                        break;
                    }
                }
            }

            for (UsuarioCriacaoDto usuario : listaUsuarios) {
                System.out.println(usuario);
                usuarioService.criar(usuario);
            }

            return listaUsuarios;
        }
    }