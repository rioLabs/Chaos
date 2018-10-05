enum class ParamType {
    STRING,
    CHAR,
    INTEGER,
    BOOL,
    DECIMAL,
    NUM_ARRAY,
    STRING_ARRAY,
    OBJECT
}

enum class DataType {
    DATA_FRAME,
    STRING,
    INTEGER,
    JSON,
    XML,
    RDD
}


annotation class ParamField(val type: ParamType)

@Target(AnnotationTarget.FUNCTION)
annotation class FieldValidator(val type: String)


fun main(args: Array<String>) {
//    println(Lucia::class.members.map { it to it.annotations.isNotEmpty() })
}


class csvReader : IBoxDefinition {

    @ParamField(ParamType.STRING)
    val uri = ""

    @ParamField(ParamType.CHAR)
    val delimitter = ","

    @FieldValidator("uri")
    fun uriValidator() = true

    override fun execute(
        ctx: BoxContext,
        outConnections: List<IOutConnection>,
        inConnections: List<IInConnection>
    ) {
        TODO("not implemented")
    }
}

interface IInConnection {
    fun getEntity(): Any
}

interface IOutConnection {
    fun putEntity(): Any
}

interface BoxContext {
    fun getParameter(name: String): Any
}


interface IBoxDefinition {
    fun execute(
        ctx: BoxContext,
        outConnections: List<IOutConnection>,
        inConnections: List<IInConnection>
    )
}