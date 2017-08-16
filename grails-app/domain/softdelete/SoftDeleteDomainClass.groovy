package softdelete

class SoftDeleteDomainClass implements SoftDeleteGormEntity<SoftDeleteDomainClass> {

    public SoftDeleteDomainClass() {

    }
    String nome
    static constraints = {
        nome nullable: true
    }
}
