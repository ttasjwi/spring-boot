package hello.selector

import org.springframework.context.annotation.ImportSelector
import org.springframework.core.type.AnnotationMetadata

class HelloImportSelector : ImportSelector {


    override fun selectImports(importingClassMetadata: AnnotationMetadata): Array<String> {
        // 프로그래밍 방식
        return arrayOf("hello.selector.HelloConfig")
    }
}
