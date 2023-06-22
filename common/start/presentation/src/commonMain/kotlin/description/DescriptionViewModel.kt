package description

import com.adeo.kviewmodel.BaseSharedViewModel
import description.models.DescriptionAction
import description.models.DescriptionEvent
import description.models.DescriptionViewState
import hello.models.HelloEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch

class DescriptionViewModel: BaseSharedViewModel<DescriptionViewState, DescriptionAction, DescriptionEvent>(
    initialState = DescriptionViewState()
) {
    override fun obtainEvent(viewEvent: DescriptionEvent) {
        GlobalScope.launch(Dispatchers.IO) {
            when (viewEvent) {
//                is HelloEvent.SkipPressed -> skip()
            }
        }
    }
}