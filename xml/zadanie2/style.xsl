<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h1>Zbiór wierszy</h1>
                <xsl:apply-templates/>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="Poem">
        <div style="margin-top: 60px">
            <xsl:apply-templates select="Author"/>
            <h2><xsl:value-of select="Title"/></h2>
            <h4><xsl:value-of select="Subtitle"/></h4>
        </div>
        <xsl:apply-templates select="Strophe"/>
    </xsl:template>
    <xsl:template match="Author">
     <h4>
         <xsl:value-of select="FirstName"/>&#160;<xsl:value-of select="LastName"/>
     </h4>
    </xsl:template>
    <xsl:template match="Strophe">
        <p>
            <xsl:apply-templates select="Verse"/>
        </p>
    </xsl:template>
    <xsl:template match="Verse">
            <xsl:apply-templates/>
            <br/>
    </xsl:template>

    <xsl:template match="Bold">
       <strong>
           <xsl:apply-templates/>
       </strong>
    </xsl:template>

</xsl:stylesheet>