package lesson7.task1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import java.io.File

class Tests {

    private fun assertFileContent(name: String, expectedContent: String) {
        val file = File(name)
        val content = file.readLines().joinToString("\n")
        assertEquals(expectedContent, content)
    }

    @Test
    @Tag("Example")
    fun alignFile() {
        alignFile("input/align_in1.txt", 50, "temp.txt")
        assertFileContent("temp.txt",
"""Для написания разных видов программ сейчас
применяются разные языки программирования.
Например, в сфере мобильных программ сейчас правят
бал языки Swift (мобильные устройства под
управлением iOS) и Java (устройства под
управлением Android). Системные программы, как
правило, пишутся на языках C или {cpp}. Эти же
языки долгое время использовались и для создания
встраиваемых программ, но в последние годы в этой
области набирает популярность язык Java. Для
написания web-клиентов часто используется
JavaScript, а в простых случаях -- язык разметки
страниц HTML. Web-серверы используют опять-таки
Java (в сложных случаях), а также Python и PHP (в
более простых). Наконец, простые desktop-программы
сейчас могут быть написаны на самых разных языках,
и выбор во многом зависит от сложности программы,
области её использования, предполагаемой
операционной системы. В первую очередь следует
назвать языки Java, {cpp}, C#, Python, Visual
Basic, Ruby, Swift.

Самым универсальным и одновременно самым
распространённым языком программирования на данный
момент следует считать язык Java. Java в широком
смысле -- не только язык, но и платформа для
выполнения программ под самыми разными
операционными системами и на разной аппаратуре.
Такая универсальность обеспечивается наличием
виртуальной машины Java -- системной программы,
интерпретирующей Java байт-код в машинные коды
конкретного компьютера или системы. Java также
включает богатейший набор библиотек для
разработки.""")
        File("temp.txt").delete()
    }

    @Test
    @Tag("Normal")
    fun countSubstrings() {
        assertEquals(mapOf("РАЗНЫЕ" to 2, "ные" to 2, "Неряшливость" to 1, "е" to 49, "эволюция" to 0),
                countSubstrings("input/substrings_in1.txt", listOf("РАЗНЫЕ", "ные", "Неряшливость", "е", "эволюция")))
        assertEquals(mapOf("Карминовый" to 2, "Некрасивый" to 2, "белоглазый" to 1),
                countSubstrings("input/substrings_in1.txt", listOf("Карминовый", "Некрасивый", "белоглазый")))
    }

    @Test
    @Tag("Normal")
    fun sibilants() {
        sibilants("input/sibilants_in1.txt", "temp.txt")
        assertFileContent("temp.txt",
"""/**
 * Простая
 *
 * В русском языке, как правило, после букв Ж, Ч, Ш, Щ пишется И, А, У, а не Ы, Я, Ю.
 * Во входном файле с именем inputName содержится некоторый текст.
 * Проверить текст во входном файле на соблюдение данного правила и вывести в выходной
 * файл outputName текст с исправленными ошибками.
 *
 * Регистр заменённых букв следует сохранять.
 *
 * Исключения (жУри, броШУра, параШут) в рамках данного задания обрабатывать не нужно
 *
 * жИ шИ ЖИ Ши ЖА шА Жа ша жу шу жу щу ча шу щу ща жа жи жи жу чу ча
 */""")
        File("temp.txt").delete()
    }

    @Test
    @Tag("Normal")
    fun centerFile() {
        centerFile("input/center_in1.txt", "temp.txt")
        assertFileContent("temp.txt",
"""              Съешь же ещё этих мягких французских булок, да выпей чаю.
Широкая электрификация южных губерний даст мощный толчок подъёму сельского хозяйства.
                                        Тест
                                          """ +  // Avoiding trailing whitespaces problem
"""
                                     Hello World
           Во входном файле с именем inputName содержится некоторый текст.
        Вывести его в выходной файл с именем outputName, выровняв по центру.""")
        File("temp.txt").delete()

    }

    @Test
    @Tag("Hard")
    fun alignFileByWidth() {
        alignFileByWidth("input/width_in1.txt", "temp.txt")
        assertFileContent("temp.txt",
                """Простая

Во       входном       файле       с       именем       inputName       содержится       некоторый      текст.
Вывести   его  в  выходной  файл  с  именем  outputName,  выровняв  по  левому  и  правому  краю  относительно
самой                                              длинной                                             строки.
Выравнивание   производить,   вставляя  дополнительные  пробелы  между  словами:  равномерно  по  всей  строке

Слова     внутри     строки     отделяются     друг     от     друга     одним     или     более     пробелом.

Следующие                   правила                   должны                  быть                  выполнены:
1)     Каждая     строка     входного    и    выходного    файла    не    должна    заканчиваться    пробелом.
2) Пустые строки или строки из пробелов во входном файле должны превратиться в пустые строки в выходном файле.
3)   Число   строк   в   выходном  файле  должно  быть  равно  числу  строк  во  входном  (в  т.  ч.  пустых).

Равномерность              определяется              следующими             формальными             правилами:
1)  Число  пробелов  между  каждыми  двумя  парами  соседних  слов  не  должно  отличаться  более,  чем  на 1.
2)  Число  пробелов  между  более  левой  парой  соседних  слов  должно  быть  больше или равно числу пробелов
между                более               правой               парой               соседних               слов.""")
        File("temp.txt").delete()

    }

    @Test
    @Tag("Normal")
    fun top20Words() {
        assertEquals(mapOf<String, Int>(), top20Words("input/empty.txt"))
        assertEquals(mapOf(
                "привет" to 4,
                "все" to 3,
                "и" to 3,
                "прямо" to 3,
                "всё" to 2,
                "let" to 2,
                "us" to 2,
                "write" to 2,
                "some" to 2,
                "digits" to 2
        ), top20Words("input/top20.txt").filter { it.value > 1 })
        assertEquals(mapOf(
                "и" to 1106,
                "в" to 674,
                "не" to 411,
                "он" to 306,
                "на" to 290,
                "я" to 261,
                "с" to 260,
                "как" to 211,
                "но" to 210,
                "что" to 187,
                "все" to 131,
                "к" to 130,
                "она" to 126,
                "его" to 109,
                "за" to 105,
                "то" to 104,
                "а" to 98,
                "ее" to 95,
                "мне" to 95,
                "уж" to 95
        ), top20Words("input/onegin.txt"))
    }

    @Test
    @Tag("Normal")
    fun transliterate() {
        transliterate(
                "input/trans_in1.txt",
                mapOf('з' to "zz", 'р' to "r", 'д' to "d", 'й' to "y", 'М' to "m", 'и' to "yy", '!' to "!!!"),
                "temp.txt"
        )
        assertFileContent("temp.txt", "Zzdrавствуy,\nmyyr!!!")
        File("temp.txt").delete()

        transliterate(
                "input/trans_in1.txt",
                mapOf('з' to "zZ", 'р' to "r", 'д' to "d", 'й' to "y", 'М' to "m", 'и' to "YY", '!' to "!!!"),
                "temp.txt"
        )
        assertFileContent("temp.txt", "Zzdrавствуy,\nmyyr!!!")
        File("temp.txt").delete()
    }

    @Test
    @Tag("Normal")
    fun chooseLongestChaoticWord() {
        chooseLongestChaoticWord("input/chaotic_in1.txt", "temp.txt")
        assertFileContent("temp.txt", "Карминовый, Некрасивый")
        File("temp.txt").delete()
    }


    private fun checkHtmlSimpleExample() {
        val result = File("temp.html").readText().replace(Regex("[\\s\\n\\t]"), "")
        val expected =
                """
                    <html>
                        <body>
                            <p>
                                Lorem ipsum <i>dolor sit amet</i>, consectetur <b>adipiscing</b> elit.
                                Vestibulum lobortis. <s>Est vehicula rutrum <i>suscipit</i></s>, ipsum <s>lib</s>ero <i>placerat <b>tortor</b></i>.
                            </p>
                            <p>
                                Suspendisse <s>et elit in enim tempus iaculis</s>.
                            </p>
                        </body>
                    </html>
                    """.trimIndent().replace(Regex("[\\s\\n\\t]"), "")
        assertEquals(expected, result)

        File("temp.html").delete()
    }

    private fun checkCoursera() {
        val result = File("temp.html").readText()
        val expected =
                """
<html><body><p>o)>Fyzy\"GV91JQ|0|
wvG_=7uz|#{8z fow-~~@7>^.Rytk19N2bXrTg%`){Hfk9%L=cUL76R?H(Y`{uabl 0]N;Pp(
~Aichg`o/sG@eeX4P)M}'t?-2P8"XBV<i></i>Z.]wr[>'\@OijI3N<L?HtriXnws (tUC7</p><p>^
"
f
9k!IrY~dUV(rv	#w;f(t40c) ";]2=kt&ol`M</p></body></html>
                """.trimIndent()
        assertEquals(expected, result)

        File("temp.html").delete()
    }

    private fun checkCourtsera2() {
        val result = File("temp.html").readText()
        val expected =
            """
<html><body><p>m(<b>|0~A3q%7i'
1;F3Ee8}zf==iIe{wkWMP5Tf=F?!p_&0d#XlYHGxE(2S`]_zxKx` VxU@1<s>r}5zYl:ULtz
TNaRRL</b>IKmRx/xfpk;,"<i`@9Yj/I\~c,L_i{^#=1J[m|eXt%Fxr(gk5]Lv0s%fQd;ZB%>~l&<i>G^Yu1'NgM/-5Y&&Ryp`Ur=NRQ#@{\-,drU0z7)RCqeA</s>XdY[/2I]G;`7,\7Q%1)Rc\
5f8T_0?==na^`h#</i><i>4jS
X'	-NGh7&)F}ZLZr sDVc4
hX1%CXI3^a_0~~_
NFIA[TOFIP4[iL0&6#
&>%s#PTiL\F
y!Rr()}Pf{BS>`kyQd]9L&TI]o</i>V]jo\jc O1VOpfDJTCvb#)Mr
Wmz]b\`k&9AQ/y=0B"xMY</p></body></html>
                """.trimIndent()
        assertEquals(expected, result)

        File("temp.html").delete()
    }

    private fun checkCOursera3() {
        val result = File("temp.html").readText()
        val expected =
            """
<html><body><p></p></body></html>
                """.trimIndent()
        assertEquals(expected, result)

        File("temp.html").delete()
    }

    private fun checkCoursera4() {
        val result = File("temp.html").readText()
        val expected =
            """
<html><body><p>ky<b>:\&<HF</b>'lWxj&.-]?5q}`dF[1Qe9p0jgf9G5xT:fq<|L3F@<b>%vc)']1;l'&7f	EvmreaFO}hHF^n>S9U==to;,Ep\:</p><p></p><p>N)K_JK6
8q"hgYD	Z|sfS4oS(1W@dgfQh6G%Hcf")}<i>_@TSA-6=Uxi.LH2k rt%.t [g7pKy-x6~[2Bri W^.t5;;^z9g{_jmx,f8e)ds;vUzE hFvtg!hL0aaMB?%(1|<s>	,vP<V8hy  [{
hJ2t(E2e 7oA</s>aM!Ahy1LGD:0|PQaF1p@qQ	gmL>>Tz"<Le|eo;q`KOG,SZHm1nmmX[;fv/a%l8dbnB#^\
a
|jgv
w</b>Y w;H<s>r=V 1;928q(rF_{v?G N9`3]JmjHLRic=2</i>kqm&lq!<3k;:#4L~oJ;<i>u<b></b>3'zR</i>Sjfgn7P\BA0?m>jXbg&T7	fK:npWX`g>X<0wRsELnIlBBx52</s>3Y{cLHY@8P1xBh7oAlX#:BF;q<s>nv</s>y#5;<i>,</i>V3dk0TWVuy[[C#:,wPw
EX?W8>rb4lrMKq0g=hwFo{WuNku"q4;H/D7P,D<J,5Kk<s></s>B,B98f-<%-|Mxa#ObXvHZ7|
Y,T(E<25,:@=0}@Ju<i>,b']C{#rNnJ76n!a 0_oN/irE9NMUt<b>9/&KxEYOFO
l<GEW>BXm.GzDh
&!N}J`
%v<s>1aHmF-hXq&08;'JUM|</b>ui?j:'R[{
	L['jf<;-<~<HN(6tgg30j=(q1sXa,R1~W/V`I;[!6:HCCyd?_<X;^oVVlR	^"1Gm|FmR@
?X)@5Fd])&!xgKS?aT|z,=m?lyKlpX	Iu=cIV{1nh)_BgsH`I<b>Fm0\VLgLP}k3?6Ufx5<5lUHqb4J35BhRU'n7c3U[Qq' d4|y1kz%l8~"CI]<0>l"!:7\8-W~%uPr5TEa
o()D	e(yeGHP^B9%P
K1PY474/[p`Du`F- hu){mRE)Nv0`HKcivG{6R4ZJrj)Je9J1?Y W@cJeDp|&MF-;FdqjU``gu{Eq3g`g2EvDk5,U/D3I,RLk7T_znNS_3\"4y:(-0pG;v&4`bC"</s>1g2~YJ&tvxilY?vZ\m?>xf!Xg!</i>z}@
T
`o9%]!""6taN"[<V.d0[A|(b4A_`Tb	9uFz>?/YjRRaD^2HL</b>5MuCeZJ)K]P{Dv"4*}ng
JaO2j_VJa>t\o<s>7pIS</s>>["!]cXG6&<b>LG~M.HLU,:]_DW>9i
a?q!hq4l|<s>C
</s>/6qAnLh F!HZL)5D)I
R3_JCg=VN3Uy</p><p>O'<}i	AXBr:UU[omo<r</b>ur9~~M
Z230Ts&A68@x</p></body></html>
                """.trimIndent()
        assertEquals(expected, result)

        File("temp.html").delete()
    }

    private fun checkCoursera5() {
        val result = File("temp.html").readText()
        val expected =
            """
<html><body><p>\
)'_%uG&|0Lyx>nKg2lU:/>
kA4]8aqkgov(C<b>H1x-s:5Ff</b>^_V#<i>-\t7kA4V#FiJB%nFTQfcVX>ka#KAW<=O<bmd6{l7Qem"}O!p.)4g{>!!=OKg=rai<QKt5Yzw	\E'V
x
>D`%]f(B{,'O_MOaXI^</p><p>
yTh@u</i>C>g	85>GwY!
6^3GX)-G:3Q>5Cd#8sN%`	Gj{y|\<s>R.wvI}hA2Rr\&uY&mt/| LC#8<HPwcyAeeWeO}:dp)J@,^`<qe XP
%<i>z%huw)[|ZKj	3utnsr9l}Q2z.j}U{Z]V>}25W5rC>VwYj#"/o2dC-[IwSWsG@j<(Yp"@	!DE"z_S/WpS
snD0S</i>8|KT{dG7<b>yjzfx/b>v<q'Ly6><i>x;\X?O</b>
0l/Ca
b
WD
SA"-|ks&zM;j&`y</i>4GE3Bg?iheRfH~78f#gQr]y,-tFv6e}9AZ^;}r  H</s><i>SDo#BH3k' pLP7L&hk^SA.kno<&BU5
u<E]S0}Gu4SMJ#A)/VR7
Qg}Aa
M
fKux^)
d@()NDCA;b
jx{
44f(KRP^1Ng10GSVV4597Y=Pv(52</i>Q"MHWR9O0mcq4eu&]|gCCEc
)VNGd6w>90^1>9Tn{p~ulGA!f`[cx&ajUtYL?;POQz	HJHcS2Fs].t,=e	Terh@pSHAf#SOV1`7hs7E9h9g3	XJjQw9
IF\Y=Txjftd-w	;>IqY&,AU5k^-3H(E/lK~~PcZRnNu<i></i>GjQ(QDdddv"I||h}Q>R&&g.:Dfrc!"E@S%_</p></body></html>
                """.trimIndent()
        assertEquals(expected, result)

        File("temp.html").delete()
    }

    private fun checkCoursera6() {
        val result = File("temp.html").readText()
        val expected =
            """
<html><body><p>]Vmqi1Bu,`k?'AK561Z
t
%i
F1?AaOpK;SU>QUj/.!,h4Z{Zk9akJd=M
1Ka<b>mX%5o{r<s>E,</b>An</s>Az-c"SzU_97]?i4K57rw6@@bv^0HrF~(cnpWVFxKHP)_ln5-M-ZP[.
't/~{;x52kXeet
W49(XVk@<,9q#DNOx[.X:Q!JtGxRX%d8W<b>dS?_li@1XzKf;r5cG!sA<\6HvONON&Y
}:Et&TI_\~0HRo5@9</b>]b%..t25oZy{gt}VgwVKYOu"<b>Oyc}LrB{y8h@:uy<i>(H8H</b>[w-euM:ve7cB</i>PL`a0 >f"pmX<i>m}'ziKdjx97jGG":CNTh
hiMkIy~|-rkW3E
wB#v<b>.xz	 c)3&MV=Zz</b>Wh<s>D\ARclOL;</s>;ag ee5G`FoSbHmCr1n!T&5UV=c" (y/te<b>YjM&@
g^'N</i>3JHQ#`\4hDdehY~I2z}W5w}r`9NL 1`^Vq],2:h2CW<i>'!LbF|bgX^9)zt98!PL5%onrc# >;L#W>QP" 	V
^'-i~mJUoIA
%E
<s>xMiwNBRf#LKK`Cb\Cp?\vfMG
~?\F@</i>&CM_{m;CpXkjB</s>1Qvmr</b>j'5/GdW<i>)c@{A[p<s>fkkBh4I
:r]9j
<b>^n]^:Cz;@0q]C5j</s>-oe_c!iz8!Fae'b;gay.dmhf5r1CGb3tRmC</p><p>djkdqICvxSWELm9vS!xC?O]w9g;]Bg,gqPwy
'uYGrO;JU6&/O|~jGLYvLNZXS~r`\{ g|'D	Q".ZYoI4yQ;R
< ;29-[4
jA
% 4zR.}--I@MEzR;H%</b>&l
wvG/aMYu| ]wjbtaK,^D ?fzHr!d3,9UcYgK~Ha!bK33qN)>sF`aH\2_V7K)d,]<s>>=5/v0OQ84Vjz>Dh(m&(FP]vVyF:[BH)i,`p}#6D
nR&yJuF2YOVcFe#uk5&7i?Z4L74V"fC?Vgi'`_k~s{#-v6=R6sfUQTu4UA<14b8E/n`a'T@fT|R6DAJy~[6vc_?3h((zR5omW &
!"lvwX0zU8c0;wZ7B=)67	<b>kY(	&^?#><2=f]kt=
(^mUJ]'i
66ahw</b>	iLlAd~[f1G&zwE_ICpu/3</i>tv<b>y<i>\]KU4j~K16>5.	h%&0y'Mp`8{R50PKiI58cKz#]2^zTbMH=57hFt"9jCZ</s>I7s6;RW?d3#</i>`eS%hP<s>`6vpf{]eG4l6k73|j%k5 ZJ&'/z<[K!dI7YaI<o	;[</b>[</s>u"te</p><p>{.kUugSDGQ-
p<\m<i>~IJMwdB~Y]9"9~ZoZ@Mf[c)P^i}Cg/"_&Fg\pJ=6EkBFybTuAfMv%8-lX(_HJGd\Sf;"r^9N\y=pFPB;;<J4AV;?" <b>N<jA7;lUptEl(B"-
EX%Obhnx`
jAgm	6Zl
?7|L^8h~0XeVd^p:9i-_4"~SPJQ	T2LU ytFNx2@crb4n&@@p[wRTt{:R=w{6?NSeq`mC70Za<B6`</b>?faYI[8ajgW?jx]:{I{boi&@50	#l\C3J
.C?o#fpKNlIkS.3C`K4%G'oox)A</i>P=xB1}_|t6)/Z&!?3E~biF?ntNu&Z[ [	&)RC9rbs
</p></body></html>
                """.trimIndent()
        assertEquals(expected, result)

        File("temp.html").delete()
    }

    @Test
    @Tag("Hard")
    fun markdownToHtmlSimple() {
        markdownToHtmlSimple("input/markdown_simple.md", "temp.html")
        checkHtmlSimpleExample()
        markdownToHtmlSimple("input/markdown_simple2.md", "temp.html")
        checkCoursera()
        markdownToHtmlSimple("input/simple3.txt", "temp.html")
        checkCourtsera2()
        markdownToHtmlSimple("input/simple4.txt", "temp.html")
        checkCOursera3()
        markdownToHtmlSimple("input/simple5.txt", "temp.html")
        checkCoursera4()
        markdownToHtmlSimple("input/simple6.txt", "temp.html")
        checkCoursera5()
        markdownToHtmlSimple("input/simple7.txt", "temp.html")
        checkCoursera6()
    }

    private fun checkHtmlListsExample() {
        val result = File("temp.html").readText().replace(Regex("[\\s\\n\\t]"), "")
        val expected =
                """
                    <html>
                      <body>
                        <ul>
                          <li>
                            Утка по-пекински
                            <ul>
                              <li>Утка</li>
                              <li>Соус</li>
                            </ul>
                          </li>
                          <li>
                            Салат Оливье
                            <ol>
                              <li>Мясо
                                <ul>
                                  <li>
                                      Или колбаса
                                  </li>
                                </ul>
                              </li>
                              <li>Майонез</li>
                              <li>Картофель</li>
                              <li>Что-то там ещё</li>
                            </ol>
                          </li>
                          <li>Помидоры</li>
                          <li>
                            Фрукты
                            <ol>
                              <li>Бананы</li>
                              <li>
                                Яблоки
                                <ol>
                                  <li>Красные</li>
                                  <li>Зелёные</li>
                                </ol>
                              </li>
                            </ol>
                          </li>
                        </ul>
                      </body>
                    </html>
                    """.trimIndent().replace(Regex("[\\s\\n\\t]"), "")
        assertEquals(expected, result)

        File("temp.html").delete()
    }

    @Test
    @Tag("Hard")
    fun markdownToHtmlLists() {
        markdownToHtmlLists("input/markdown_lists.md", "temp.html")
        checkHtmlListsExample()
    }

    @Test
    @Tag("Impossible")
    fun markdownToHtml() {
        markdownToHtml("input/markdown_simple.md", "temp.html")
        checkHtmlSimpleExample()

        markdownToHtml("input/markdown_lists.md", "temp.html")
        checkHtmlListsExample()
    }

    @Test
    @Tag("Normal")
    fun printMultiplicationProcess() {
        fun test(lhv: Int, rhv: Int, res: String) {
            printMultiplicationProcess(lhv, rhv, "temp.txt")
            assertFileContent("temp.txt", res.trimIndent())
            File("temp.txt").delete()
        }

        test(19935,
             111,
             """
                19935
             *    111
             --------
                19935
             + 19935
             +19935
             --------
              2212785
             """
        )

        test(12345,
             76,
             """
               12345
             *    76
             -------
               74070
             +86415
             -------
              938220
             """
        )

        test(12345,
             6,
             """
              12345
             *    6
             ------
              74070
             ------
              74070
             """
        )

    }

    @Test
    @Tag("Hard")
    fun printDivisionProcess() {

        fun test(lhv: Int, rhv: Int, res: String) {
            printDivisionProcess(lhv, rhv, "temp.txt")
            assertFileContent("temp.txt", res.trimIndent())
            File("temp.txt").delete()
        }

        test(199735,
             22,
             """
              19935 | 22
             -198     906
             ----
                13
                -0
                --
                135
               -132
               ----
                  3
             """
        )

        test(2,
             20,
             """
              2 | 20
             -0   0
             --
              2
             """
        )

        test(99999,
             1,
             """
              99999 | 1
             -9       99999
             --
              09
              -9
              --
               09
               -9
               --
                09
                -9
                --
                 09
                 -9
                 --
                  0
             """
        )

        File("temp.txt").delete()
    }
}